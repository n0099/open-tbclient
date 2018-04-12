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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdListView FL;
    private View aIv;
    private TbPageContext<?> adf;
    private TextView adw;
    private ViewEventCenter cGR;
    private View cIM;
    private TextView cIN;
    private View cIO;
    private TextView cIP;
    private c cIQ;
    private MultiConcernModel cIR;
    private MultiConcernModel.a cIS;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != a.this.aIv) {
                if (view2 != a.this.cIN) {
                    if (view2 == a.this.cIP) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new al("c12239").ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.w(arrayList)) {
                            a.this.OL();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hg()) {
                            l.showToast(a.this.adf.getPageActivity(), d.k.neterror);
                            return;
                        } else {
                            a.this.cIP.setClickable(false);
                            if (a.this.cIR == null) {
                                a.this.cIR = new MultiConcernModel(a.this.adf);
                            }
                            if (a.this.cIS == null) {
                                a.this.cIS = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void O(int i, String str) {
                                        a.this.cIP.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.adf.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.OL();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cGR != null) {
                                            a.this.cGR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cIR.a(a.this.cIS);
                            }
                            a.this.cIR.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.OL();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new al("c12240").ac("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.adf = tbPageContext;
            this.mRootView = viewGroup;
            this.cGR = viewEventCenter;
        }
    }

    private void createView() {
        this.aIv = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cIM = this.aIv.findViewById(d.g.rec_forum_list_container);
        this.cIN = (TextView) this.aIv.findViewById(d.g.view_skip);
        this.adw = (TextView) this.aIv.findViewById(d.g.view_recommend_tip);
        this.cIO = this.aIv.findViewById(d.g.view_top_divider);
        this.FL = (BdListView) this.aIv.findViewById(d.g.listview_forums);
        this.cIP = (TextView) this.aIv.findViewById(d.g.view_forums_concern);
        this.cIP.setClickable(true);
        this.cIQ = new c(this.adf.getPageActivity());
        this.FL.setAdapter((ListAdapter) this.cIQ);
        this.FL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cIQ.setData(a.this.forumList);
                    a.this.cIQ.notifyDataSetChanged();
                }
            }
        });
        this.cIN.setOnClickListener(this.mClickListener);
        this.cIP.setOnClickListener(this.mClickListener);
        this.aIv.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aO(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.w(list)) {
                OL();
                return;
            }
            if (this.aIv == null) {
                createView();
            }
            this.cIP.setClickable(true);
            this.isShowing = true;
            if (this.aIv.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.aIv, false);
            }
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.adf.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aIv.setVisibility(0);
                    a.this.cIM.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cIQ.setData(this.forumList);
            this.cIQ.notifyDataSetChanged();
            TiebaStatic.log(new al("c12238").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void OL() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aIv != null && this.mRootView != null) {
                this.aIv.setVisibility(8);
                if (this.aIv.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aIv);
                }
            }
        }
    }

    public void onDestroy() {
        OL();
        if (this.cIR != null) {
            this.cIR.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        ak.h(this.cIN, d.C0126d.cp_cont_d);
        ak.h(this.adw, d.C0126d.cp_cont_d);
        ak.j(this.cIO, d.C0126d.cp_bg_line_c);
        ak.h(this.cIP, d.C0126d.common_color_10310);
        ak.i(this.cIP, d.f.bule_bg_commen_label_button);
        ak.i(this.aIv, d.C0126d.black_alpha50);
        ak.i(this.cIM, d.f.bg_recommend_forum_by_tag);
        this.cIQ.notifyDataSetChanged();
    }

    public View aln() {
        return this.aIv;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
