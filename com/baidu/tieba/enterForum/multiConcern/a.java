package com.baidu.tieba.enterForum.multiConcern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private TextView aQK;
    private TbPageContext<?> aQs;
    private BdListView avm;
    private View bvY;
    private ViewEventCenter dme;
    private TextView dnA;
    private View dnB;
    private TextView dnC;
    private c dnD;
    private MultiConcernModel dnE;
    private MultiConcernModel.a dnF;
    private View dnz;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bvY) {
                if (view != a.this.dnA) {
                    if (view == a.this.dnC) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").aa("uid", TbadkCoreApplication.getCurrentAccount()).aa(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.E(arrayList)) {
                            a.this.Vs();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.pa()) {
                            l.showToast(a.this.aQs.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.dnC.setClickable(false);
                            if (a.this.dnE == null) {
                                a.this.dnE = new MultiConcernModel(a.this.aQs);
                            }
                            if (a.this.dnF == null) {
                                a.this.dnF = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void E(int i, String str) {
                                        a.this.dnC.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aQs.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Vs();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dme != null) {
                                            a.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dnE.a(a.this.dnF);
                            }
                            a.this.dnE.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Vs();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").aa("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aQs = tbPageContext;
            this.mRootView = viewGroup;
            this.dme = viewEventCenter;
        }
    }

    private void createView() {
        this.bvY = LayoutInflater.from(this.aQs.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dnz = this.bvY.findViewById(d.g.rec_forum_list_container);
        this.dnA = (TextView) this.bvY.findViewById(d.g.view_skip);
        this.aQK = (TextView) this.bvY.findViewById(d.g.view_recommend_tip);
        this.dnB = this.bvY.findViewById(d.g.view_top_divider);
        this.avm = (BdListView) this.bvY.findViewById(d.g.listview_forums);
        this.dnC = (TextView) this.bvY.findViewById(d.g.view_forums_concern);
        this.dnC.setClickable(true);
        this.dnD = new c(this.aQs.getPageActivity());
        this.avm.setAdapter((ListAdapter) this.dnD);
        this.avm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.f(a.this.forumList, i) != null) {
                    ((b) v.f(a.this.forumList, i)).isSelected = !((b) v.f(a.this.forumList, i)).isSelected;
                    a.this.dnD.setData(a.this.forumList);
                    a.this.dnD.notifyDataSetChanged();
                }
            }
        });
        this.dnA.setOnClickListener(this.mClickListener);
        this.dnC.setOnClickListener(this.mClickListener);
        this.bvY.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aR(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.E(list)) {
                Vs();
                return;
            }
            if (this.bvY == null) {
                createView();
            }
            this.dnC.setClickable(true);
            this.isShowing = true;
            if (this.bvY.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.bvY, false);
            }
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aQs.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bvY.setVisibility(0);
                    a.this.dnz.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dnD.setData(this.forumList);
            this.dnD.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").aa("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Vs() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bvY != null && this.mRootView != null) {
                this.bvY.setVisibility(8);
                if (this.bvY.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bvY);
                }
            }
        }
    }

    public void onDestroy() {
        Vs();
        if (this.dnE != null) {
            this.dnE.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dnA, d.C0108d.cp_cont_d);
        aj.r(this.aQK, d.C0108d.cp_cont_d);
        aj.t(this.dnB, d.C0108d.cp_bg_line_c);
        aj.r(this.dnC, d.C0108d.common_color_10310);
        aj.s(this.dnC, d.f.bule_bg_commen_label_button);
        aj.s(this.bvY, d.C0108d.black_alpha50);
        aj.s(this.dnz, d.f.bg_recommend_forum_by_tag);
        this.dnD.notifyDataSetChanged();
    }

    public View aqj() {
        return this.bvY;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
