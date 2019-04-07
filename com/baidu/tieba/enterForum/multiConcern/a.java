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
    private TextView bFK;

    /* renamed from: com  reason: collision with root package name */
    private View f5com;
    private ViewEventCenter eAK;
    private View eDL;
    private TextView eDM;
    private View eDN;
    private TextView eDO;
    private c eDP;
    private MultiConcernModel eDQ;
    private MultiConcernModel.a eDR;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.f5com) {
                if (view != a.this.eDM) {
                    if (view == a.this.eDO) {
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
                            a.this.eDO.setClickable(false);
                            if (a.this.eDQ == null) {
                                a.this.eDQ = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eDR == null) {
                                a.this.eDR = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ae(int i, String str) {
                                        a.this.eDO.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aAy();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eAK != null) {
                                            a.this.eAK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eDQ.a(a.this.eDR);
                            }
                            a.this.eDQ.K(arrayList);
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
            this.eAK = viewEventCenter;
        }
    }

    private void createView() {
        this.f5com = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eDL = this.f5com.findViewById(d.g.rec_forum_list_container);
        this.eDM = (TextView) this.f5com.findViewById(d.g.view_skip);
        this.bFK = (TextView) this.f5com.findViewById(d.g.view_recommend_tip);
        this.eDN = this.f5com.findViewById(d.g.view_top_divider);
        this.Pj = (BdListView) this.f5com.findViewById(d.g.listview_forums);
        this.eDO = (TextView) this.f5com.findViewById(d.g.view_forums_concern);
        this.eDO.setClickable(true);
        this.eDP = new c(this.mContext.getPageActivity());
        this.Pj.setAdapter((ListAdapter) this.eDP);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eDP.setData(a.this.forumList);
                    a.this.eDP.notifyDataSetChanged();
                }
            }
        });
        this.eDM.setOnClickListener(this.mClickListener);
        this.eDO.setOnClickListener(this.mClickListener);
        this.f5com.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bw(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.T(list)) {
                aAy();
                return;
            }
            if (this.f5com == null) {
                createView();
            }
            this.eDO.setClickable(true);
            this.isShowing = true;
            if (this.f5com.getParent() == null) {
                e.aY(this.mRootView).a(this.mRootView, this.f5com, false);
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.f5com.setVisibility(0);
                    a.this.eDL.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eDP.setData(this.forumList);
            this.eDP.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aAy() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.f5com != null && this.mRootView != null) {
                this.f5com.setVisibility(8);
                if (this.f5com.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.f5com);
                }
            }
        }
    }

    public void onDestroy() {
        aAy();
        if (this.eDQ != null) {
            this.eDQ.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eDM, d.C0277d.cp_cont_d);
        al.j(this.bFK, d.C0277d.cp_cont_d);
        al.l(this.eDN, d.C0277d.cp_bg_line_c);
        al.j(this.eDO, d.C0277d.common_color_10310);
        al.k(this.eDO, d.f.bule_bg_commen_label_button);
        al.k(this.f5com, d.C0277d.black_alpha50);
        al.k(this.eDL, d.f.bg_recommend_forum_by_tag);
        this.eDP.notifyDataSetChanged();
    }

    public View aWZ() {
        return this.f5com;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
