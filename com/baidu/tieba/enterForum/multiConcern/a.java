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
    private TbPageContext<?> aRR;
    private TextView aSj;
    private BdListView avh;
    private View byi;
    private ViewEventCenter doV;
    private View dqt;
    private TextView dqu;
    private View dqv;
    private TextView dqw;
    private c dqx;
    private MultiConcernModel dqy;
    private MultiConcernModel.a dqz;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.byi) {
                if (view != a.this.dqu) {
                    if (view == a.this.dqw) {
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
                            l.showToast(a.this.aRR.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.dqw.setClickable(false);
                            if (a.this.dqy == null) {
                                a.this.dqy = new MultiConcernModel(a.this.aRR);
                            }
                            if (a.this.dqz == null) {
                                a.this.dqz = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void F(int i, String str) {
                                        a.this.dqw.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aRR.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Wk();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.doV != null) {
                                            a.this.doV.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dqy.a(a.this.dqz);
                            }
                            a.this.dqy.E(arrayList);
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
            this.aRR = tbPageContext;
            this.mRootView = viewGroup;
            this.doV = viewEventCenter;
        }
    }

    private void createView() {
        this.byi = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dqt = this.byi.findViewById(d.g.rec_forum_list_container);
        this.dqu = (TextView) this.byi.findViewById(d.g.view_skip);
        this.aSj = (TextView) this.byi.findViewById(d.g.view_recommend_tip);
        this.dqv = this.byi.findViewById(d.g.view_top_divider);
        this.avh = (BdListView) this.byi.findViewById(d.g.listview_forums);
        this.dqw = (TextView) this.byi.findViewById(d.g.view_forums_concern);
        this.dqw.setClickable(true);
        this.dqx = new c(this.aRR.getPageActivity());
        this.avh.setAdapter((ListAdapter) this.dqx);
        this.avh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.f(a.this.forumList, i) != null) {
                    ((b) v.f(a.this.forumList, i)).isSelected = !((b) v.f(a.this.forumList, i)).isSelected;
                    a.this.dqx.setData(a.this.forumList);
                    a.this.dqx.notifyDataSetChanged();
                }
            }
        });
        this.dqu.setOnClickListener(this.mClickListener);
        this.dqw.setOnClickListener(this.mClickListener);
        this.byi.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aT(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.E(list)) {
                Wk();
                return;
            }
            if (this.byi == null) {
                createView();
            }
            this.dqw.setClickable(true);
            this.isShowing = true;
            if (this.byi.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.byi, false);
            }
            e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aRR.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.byi.setVisibility(0);
                    a.this.dqt.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dqx.setData(this.forumList);
            this.dqx.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Wk() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.byi != null && this.mRootView != null) {
                this.byi.setVisibility(8);
                if (this.byi.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.byi);
                }
            }
        }
    }

    public void onDestroy() {
        Wk();
        if (this.dqy != null) {
            this.dqy.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dqu, d.C0140d.cp_cont_d);
        aj.r(this.aSj, d.C0140d.cp_cont_d);
        aj.t(this.dqv, d.C0140d.cp_bg_line_c);
        aj.r(this.dqw, d.C0140d.common_color_10310);
        aj.s(this.dqw, d.f.bule_bg_commen_label_button);
        aj.s(this.byi, d.C0140d.black_alpha50);
        aj.s(this.dqt, d.f.bg_recommend_forum_by_tag);
        this.dqx.notifyDataSetChanged();
    }

    public View aqZ() {
        return this.byi;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
