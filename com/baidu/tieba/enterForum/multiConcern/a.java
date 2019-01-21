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
    private TextView axH;
    private View beH;
    private ViewEventCenter drf;
    private View dsT;
    private TextView dsU;
    private View dsV;
    private TextView dsW;
    private c dsX;
    private MultiConcernModel dsY;
    private MultiConcernModel.a dsZ;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.beH) {
                if (view != a.this.dsU) {
                    if (view == a.this.dsW) {
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
                            a.this.dsW.setClickable(false);
                            if (a.this.dsY == null) {
                                a.this.dsY = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.dsZ == null) {
                                a.this.dsZ = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void M(int i, String str) {
                                        a.this.dsW.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.ZZ();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.drf != null) {
                                            a.this.drf.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dsY.a(a.this.dsZ);
                            }
                            a.this.dsY.H(arrayList);
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
            this.drf = viewEventCenter;
        }
    }

    private void createView() {
        this.beH = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dsT = this.beH.findViewById(e.g.rec_forum_list_container);
        this.dsU = (TextView) this.beH.findViewById(e.g.view_skip);
        this.axH = (TextView) this.beH.findViewById(e.g.view_recommend_tip);
        this.dsV = this.beH.findViewById(e.g.view_top_divider);
        this.OQ = (BdListView) this.beH.findViewById(e.g.listview_forums);
        this.dsW = (TextView) this.beH.findViewById(e.g.view_forums_concern);
        this.dsW.setClickable(true);
        this.dsX = new c(this.mContext.getPageActivity());
        this.OQ.setAdapter((ListAdapter) this.dsX);
        this.OQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.dsX.setData(a.this.forumList);
                    a.this.dsX.notifyDataSetChanged();
                }
            }
        });
        this.dsU.setOnClickListener(this.mClickListener);
        this.dsW.setOnClickListener(this.mClickListener);
        this.beH.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bn(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.I(list)) {
                ZZ();
                return;
            }
            if (this.beH == null) {
                createView();
            }
            this.dsW.setClickable(true);
            this.isShowing = true;
            if (this.beH.getParent() == null) {
                d.ad(this.mRootView).a(this.mRootView, this.beH, false);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.beH.setVisibility(0);
                    a.this.dsT.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dsX.setData(this.forumList);
            this.dsX.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").aB("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void ZZ() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.beH != null && this.mRootView != null) {
                this.beH.setVisibility(8);
                if (this.beH.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.beH);
                }
            }
        }
    }

    public void onDestroy() {
        ZZ();
        if (this.dsY != null) {
            this.dsY.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dsU, e.d.cp_cont_d);
        al.h(this.axH, e.d.cp_cont_d);
        al.j(this.dsV, e.d.cp_bg_line_c);
        al.h(this.dsW, e.d.common_color_10310);
        al.i(this.dsW, e.f.bule_bg_commen_label_button);
        al.i(this.beH, e.d.black_alpha50);
        al.i(this.dsT, e.f.bg_recommend_forum_by_tag);
        this.dsX.notifyDataSetChanged();
    }

    public View awU() {
        return this.beH;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
