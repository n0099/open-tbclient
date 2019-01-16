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
import com.baidu.tbadk.k.d;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView OQ;
    private TextView axG;
    private View beG;
    private ViewEventCenter dre;
    private View dsS;
    private TextView dsT;
    private View dsU;
    private TextView dsV;
    private c dsW;
    private MultiConcernModel dsX;
    private MultiConcernModel.a dsY;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.beG) {
                if (view != a.this.dsT) {
                    if (view == a.this.dsV) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").aB("uid", TbadkCoreApplication.getCurrentAccount()).aB(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.I(arrayList)) {
                            a.this.ZZ();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.ll()) {
                            l.showToast(a.this.mContext.getPageActivity(), e.j.neterror);
                            return;
                        } else {
                            a.this.dsV.setClickable(false);
                            if (a.this.dsX == null) {
                                a.this.dsX = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.dsY == null) {
                                a.this.dsY = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void M(int i, String str) {
                                        a.this.dsV.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.ZZ();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dre != null) {
                                            a.this.dre.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dsX.a(a.this.dsY);
                            }
                            a.this.dsX.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.ZZ();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").aB("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.dre = viewEventCenter;
        }
    }

    private void createView() {
        this.beG = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dsS = this.beG.findViewById(e.g.rec_forum_list_container);
        this.dsT = (TextView) this.beG.findViewById(e.g.view_skip);
        this.axG = (TextView) this.beG.findViewById(e.g.view_recommend_tip);
        this.dsU = this.beG.findViewById(e.g.view_top_divider);
        this.OQ = (BdListView) this.beG.findViewById(e.g.listview_forums);
        this.dsV = (TextView) this.beG.findViewById(e.g.view_forums_concern);
        this.dsV.setClickable(true);
        this.dsW = new c(this.mContext.getPageActivity());
        this.OQ.setAdapter((ListAdapter) this.dsW);
        this.OQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.dsW.setData(a.this.forumList);
                    a.this.dsW.notifyDataSetChanged();
                }
            }
        });
        this.dsT.setOnClickListener(this.mClickListener);
        this.dsV.setOnClickListener(this.mClickListener);
        this.beG.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bn(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.I(list)) {
                ZZ();
                return;
            }
            if (this.beG == null) {
                createView();
            }
            this.dsV.setClickable(true);
            this.isShowing = true;
            if (this.beG.getParent() == null) {
                d.ad(this.mRootView).a(this.mRootView, this.beG, false);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.beG.setVisibility(0);
                    a.this.dsS.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dsW.setData(this.forumList);
            this.dsW.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").aB("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void ZZ() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.beG != null && this.mRootView != null) {
                this.beG.setVisibility(8);
                if (this.beG.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.beG);
                }
            }
        }
    }

    public void onDestroy() {
        ZZ();
        if (this.dsX != null) {
            this.dsX.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dsT, e.d.cp_cont_d);
        al.h(this.axG, e.d.cp_cont_d);
        al.j(this.dsU, e.d.cp_bg_line_c);
        al.h(this.dsV, e.d.common_color_10310);
        al.i(this.dsV, e.f.bule_bg_commen_label_button);
        al.i(this.beG, e.d.black_alpha50);
        al.i(this.dsS, e.f.bg_recommend_forum_by_tag);
        this.dsW.notifyDataSetChanged();
    }

    public View awU() {
        return this.beG;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
