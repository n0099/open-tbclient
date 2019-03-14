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
    private TextView bFI;
    private View cok;
    private ViewEventCenter eAZ;
    private View eEa;
    private TextView eEb;
    private View eEc;
    private TextView eEd;
    private c eEe;
    private MultiConcernModel eEf;
    private MultiConcernModel.a eEg;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cok) {
                if (view != a.this.eEb) {
                    if (view == a.this.eEd) {
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
                            a.this.aAB();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.lo()) {
                            l.showToast(a.this.mContext.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.eEd.setClickable(false);
                            if (a.this.eEf == null) {
                                a.this.eEf = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eEg == null) {
                                a.this.eEg = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ac(int i, String str) {
                                        a.this.eEd.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aAB();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eAZ != null) {
                                            a.this.eAZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eEf.a(a.this.eEg);
                            }
                            a.this.eEf.K(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aAB();
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
            this.eAZ = viewEventCenter;
        }
    }

    private void createView() {
        this.cok = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eEa = this.cok.findViewById(d.g.rec_forum_list_container);
        this.eEb = (TextView) this.cok.findViewById(d.g.view_skip);
        this.bFI = (TextView) this.cok.findViewById(d.g.view_recommend_tip);
        this.eEc = this.cok.findViewById(d.g.view_top_divider);
        this.Pj = (BdListView) this.cok.findViewById(d.g.listview_forums);
        this.eEd = (TextView) this.cok.findViewById(d.g.view_forums_concern);
        this.eEd.setClickable(true);
        this.eEe = new c(this.mContext.getPageActivity());
        this.Pj.setAdapter((ListAdapter) this.eEe);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eEe.setData(a.this.forumList);
                    a.this.eEe.notifyDataSetChanged();
                }
            }
        });
        this.eEb.setOnClickListener(this.mClickListener);
        this.eEd.setOnClickListener(this.mClickListener);
        this.cok.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void by(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.T(list)) {
                aAB();
                return;
            }
            if (this.cok == null) {
                createView();
            }
            this.eEd.setClickable(true);
            this.isShowing = true;
            if (this.cok.getParent() == null) {
                e.aY(this.mRootView).a(this.mRootView, this.cok, false);
            }
            com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cok.setVisibility(0);
                    a.this.eEa.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eEe.setData(this.forumList);
            this.eEe.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").bJ("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aAB() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.cok != null && this.mRootView != null) {
                this.cok.setVisibility(8);
                if (this.cok.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cok);
                }
            }
        }
    }

    public void onDestroy() {
        aAB();
        if (this.eEf != null) {
            this.eEf.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eEb, d.C0277d.cp_cont_d);
        al.j(this.bFI, d.C0277d.cp_cont_d);
        al.l(this.eEc, d.C0277d.cp_bg_line_c);
        al.j(this.eEd, d.C0277d.common_color_10310);
        al.k(this.eEd, d.f.bule_bg_commen_label_button);
        al.k(this.cok, d.C0277d.black_alpha50);
        al.k(this.eEa, d.f.bg_recommend_forum_by_tag);
        this.eEe.notifyDataSetChanged();
    }

    public View aXb() {
        return this.cok;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
