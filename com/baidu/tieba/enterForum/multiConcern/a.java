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
    private TbPageContext<?> aRI;
    private TextView aSa;
    private BdListView auZ;
    private View bxY;
    private ViewEventCenter doM;
    private View dqk;
    private TextView dql;
    private View dqm;
    private TextView dqn;
    private c dqo;
    private MultiConcernModel dqp;
    private MultiConcernModel.a dqq;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bxY) {
                if (view != a.this.dql) {
                    if (view == a.this.dqn) {
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
                            a.this.Wk();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.pa()) {
                            l.showToast(a.this.aRI.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.dqn.setClickable(false);
                            if (a.this.dqp == null) {
                                a.this.dqp = new MultiConcernModel(a.this.aRI);
                            }
                            if (a.this.dqq == null) {
                                a.this.dqq = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void F(int i, String str) {
                                        a.this.dqn.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aRI.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Wk();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.doM != null) {
                                            a.this.doM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dqp.a(a.this.dqq);
                            }
                            a.this.dqp.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Wk();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aRI = tbPageContext;
            this.mRootView = viewGroup;
            this.doM = viewEventCenter;
        }
    }

    private void createView() {
        this.bxY = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dqk = this.bxY.findViewById(d.g.rec_forum_list_container);
        this.dql = (TextView) this.bxY.findViewById(d.g.view_skip);
        this.aSa = (TextView) this.bxY.findViewById(d.g.view_recommend_tip);
        this.dqm = this.bxY.findViewById(d.g.view_top_divider);
        this.auZ = (BdListView) this.bxY.findViewById(d.g.listview_forums);
        this.dqn = (TextView) this.bxY.findViewById(d.g.view_forums_concern);
        this.dqn.setClickable(true);
        this.dqo = new c(this.aRI.getPageActivity());
        this.auZ.setAdapter((ListAdapter) this.dqo);
        this.auZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.f(a.this.forumList, i) != null) {
                    ((b) v.f(a.this.forumList, i)).isSelected = !((b) v.f(a.this.forumList, i)).isSelected;
                    a.this.dqo.setData(a.this.forumList);
                    a.this.dqo.notifyDataSetChanged();
                }
            }
        });
        this.dql.setOnClickListener(this.mClickListener);
        this.dqn.setOnClickListener(this.mClickListener);
        this.bxY.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aT(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.E(list)) {
                Wk();
                return;
            }
            if (this.bxY == null) {
                createView();
            }
            this.dqn.setClickable(true);
            this.isShowing = true;
            if (this.bxY.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.bxY, false);
            }
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aRI.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bxY.setVisibility(0);
                    a.this.dqk.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dqo.setData(this.forumList);
            this.dqo.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Wk() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bxY != null && this.mRootView != null) {
                this.bxY.setVisibility(8);
                if (this.bxY.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bxY);
                }
            }
        }
    }

    public void onDestroy() {
        Wk();
        if (this.dqp != null) {
            this.dqp.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dql, d.C0141d.cp_cont_d);
        aj.r(this.aSa, d.C0141d.cp_cont_d);
        aj.t(this.dqm, d.C0141d.cp_bg_line_c);
        aj.r(this.dqn, d.C0141d.common_color_10310);
        aj.s(this.dqn, d.f.bule_bg_commen_label_button);
        aj.s(this.bxY, d.C0141d.black_alpha50);
        aj.s(this.dqk, d.f.bg_recommend_forum_by_tag);
        this.dqo.notifyDataSetChanged();
    }

    public View aqZ() {
        return this.bxY;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
