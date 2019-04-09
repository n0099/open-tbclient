package com.baidu.tieba.enterForum.multiConcern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView Pj;
    private TextView bFL;
    private View con;
    private ViewEventCenter eAL;
    private View eDM;
    private TextView eDN;
    private View eDO;
    private TextView eDP;
    private c eDQ;
    private MultiConcernModel eDR;
    private MultiConcernModel.a eDS;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.con) {
                if (view != a.this.eDN) {
                    if (view == a.this.eDP) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.T(arrayList)) {
                            a.this.aAy();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.lo()) {
                            l.showToast(a.this.mContext.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.eDP.setClickable(false);
                            if (a.this.eDR == null) {
                                a.this.eDR = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eDS == null) {
                                a.this.eDS = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ae(int i, String str) {
                                        a.this.eDP.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aAy();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eAL != null) {
                                            a.this.eAL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eDR.a(a.this.eDS);
                            }
                            a.this.eDR.K(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aAy();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.eAL = viewEventCenter;
        }
    }

    private void createView() {
        this.con = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eDM = this.con.findViewById(d.g.rec_forum_list_container);
        this.eDN = (TextView) this.con.findViewById(d.g.view_skip);
        this.bFL = (TextView) this.con.findViewById(d.g.view_recommend_tip);
        this.eDO = this.con.findViewById(d.g.view_top_divider);
        this.Pj = (BdListView) this.con.findViewById(d.g.listview_forums);
        this.eDP = (TextView) this.con.findViewById(d.g.view_forums_concern);
        this.eDP.setClickable(true);
        this.eDQ = new c(this.mContext.getPageActivity());
        this.Pj.setAdapter((ListAdapter) this.eDQ);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eDQ.setData(a.this.forumList);
                    a.this.eDQ.notifyDataSetChanged();
                }
            }
        });
        this.eDN.setOnClickListener(this.mClickListener);
        this.eDP.setOnClickListener(this.mClickListener);
        this.con.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bw(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.T(list)) {
                aAy();
                return;
            }
            if (this.con == null) {
                createView();
            }
            this.eDP.setClickable(true);
            this.isShowing = true;
            if (this.con.getParent() == null) {
                e.aY(this.mRootView).a(this.mRootView, this.con, false);
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.con.setVisibility(0);
                    a.this.eDM.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eDQ.setData(this.forumList);
            this.eDQ.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aAy() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.con != null && this.mRootView != null) {
                this.con.setVisibility(8);
                if (this.con.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.con);
                }
            }
        }
    }

    public void onDestroy() {
        aAy();
        if (this.eDR != null) {
            this.eDR.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eDN, d.C0277d.cp_cont_d);
        al.j(this.bFL, d.C0277d.cp_cont_d);
        al.l(this.eDO, d.C0277d.cp_bg_line_c);
        al.j(this.eDP, d.C0277d.common_color_10310);
        al.k(this.eDP, d.f.bule_bg_commen_label_button);
        al.k(this.con, d.C0277d.black_alpha50);
        al.k(this.eDM, d.f.bg_recommend_forum_by_tag);
        this.eDQ.notifyDataSetChanged();
    }

    public View aWZ() {
        return this.con;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
