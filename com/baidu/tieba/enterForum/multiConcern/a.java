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
    private TbPageContext<?> aRG;
    private TextView aRY;
    private BdListView auY;
    private View bxV;
    private ViewEventCenter doJ;
    private View dqh;
    private TextView dqi;
    private View dqj;
    private TextView dqk;
    private c dql;
    private MultiConcernModel dqm;
    private MultiConcernModel.a dqn;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bxV) {
                if (view != a.this.dqi) {
                    if (view == a.this.dqk) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.E(arrayList)) {
                            a.this.Wj();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.pa()) {
                            l.showToast(a.this.aRG.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.dqk.setClickable(false);
                            if (a.this.dqm == null) {
                                a.this.dqm = new MultiConcernModel(a.this.aRG);
                            }
                            if (a.this.dqn == null) {
                                a.this.dqn = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void F(int i, String str) {
                                        a.this.dqk.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aRG.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Wj();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.doJ != null) {
                                            a.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dqm.a(a.this.dqn);
                            }
                            a.this.dqm.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Wj();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aRG = tbPageContext;
            this.mRootView = viewGroup;
            this.doJ = viewEventCenter;
        }
    }

    private void createView() {
        this.bxV = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dqh = this.bxV.findViewById(d.g.rec_forum_list_container);
        this.dqi = (TextView) this.bxV.findViewById(d.g.view_skip);
        this.aRY = (TextView) this.bxV.findViewById(d.g.view_recommend_tip);
        this.dqj = this.bxV.findViewById(d.g.view_top_divider);
        this.auY = (BdListView) this.bxV.findViewById(d.g.listview_forums);
        this.dqk = (TextView) this.bxV.findViewById(d.g.view_forums_concern);
        this.dqk.setClickable(true);
        this.dql = new c(this.aRG.getPageActivity());
        this.auY.setAdapter((ListAdapter) this.dql);
        this.auY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.f(a.this.forumList, i) != null) {
                    ((b) v.f(a.this.forumList, i)).isSelected = !((b) v.f(a.this.forumList, i)).isSelected;
                    a.this.dql.setData(a.this.forumList);
                    a.this.dql.notifyDataSetChanged();
                }
            }
        });
        this.dqi.setOnClickListener(this.mClickListener);
        this.dqk.setOnClickListener(this.mClickListener);
        this.bxV.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aT(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.E(list)) {
                Wj();
                return;
            }
            if (this.bxV == null) {
                createView();
            }
            this.dqk.setClickable(true);
            this.isShowing = true;
            if (this.bxV.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.bxV, false);
            }
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aRG.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bxV.setVisibility(0);
                    a.this.dqh.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dql.setData(this.forumList);
            this.dql.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Wj() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bxV != null && this.mRootView != null) {
                this.bxV.setVisibility(8);
                if (this.bxV.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bxV);
                }
            }
        }
    }

    public void onDestroy() {
        Wj();
        if (this.dqm != null) {
            this.dqm.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dqi, d.C0141d.cp_cont_d);
        aj.r(this.aRY, d.C0141d.cp_cont_d);
        aj.t(this.dqj, d.C0141d.cp_bg_line_c);
        aj.r(this.dqk, d.C0141d.common_color_10310);
        aj.s(this.dqk, d.f.bule_bg_commen_label_button);
        aj.s(this.bxV, d.C0141d.black_alpha50);
        aj.s(this.dqh, d.f.bg_recommend_forum_by_tag);
        this.dql.notifyDataSetChanged();
    }

    public View aqY() {
        return this.bxV;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
