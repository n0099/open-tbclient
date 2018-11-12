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
    private BdListView OF;
    private TextView atD;
    private View bau;
    private ViewEventCenter dgT;
    private View diQ;
    private TextView diR;
    private View diS;
    private TextView diT;
    private c diU;
    private MultiConcernModel diV;
    private MultiConcernModel.a diW;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bau) {
                if (view != a.this.diR) {
                    if (view == a.this.diT) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.I(arrayList)) {
                            a.this.Yu();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.lm()) {
                            l.showToast(a.this.mContext.getPageActivity(), e.j.neterror);
                            return;
                        } else {
                            a.this.diT.setClickable(false);
                            if (a.this.diV == null) {
                                a.this.diV = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.diW == null) {
                                a.this.diW = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void J(int i, String str) {
                                        a.this.diT.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Yu();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dgT != null) {
                                            a.this.dgT.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.diV.a(a.this.diW);
                            }
                            a.this.diV.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Yu();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.dgT = viewEventCenter;
        }
    }

    private void createView() {
        this.bau = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.diQ = this.bau.findViewById(e.g.rec_forum_list_container);
        this.diR = (TextView) this.bau.findViewById(e.g.view_skip);
        this.atD = (TextView) this.bau.findViewById(e.g.view_recommend_tip);
        this.diS = this.bau.findViewById(e.g.view_top_divider);
        this.OF = (BdListView) this.bau.findViewById(e.g.listview_forums);
        this.diT = (TextView) this.bau.findViewById(e.g.view_forums_concern);
        this.diT.setClickable(true);
        this.diU = new c(this.mContext.getPageActivity());
        this.OF.setAdapter((ListAdapter) this.diU);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.diU.setData(a.this.forumList);
                    a.this.diU.notifyDataSetChanged();
                }
            }
        });
        this.diR.setOnClickListener(this.mClickListener);
        this.diT.setOnClickListener(this.mClickListener);
        this.bau.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bj(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.I(list)) {
                Yu();
                return;
            }
            if (this.bau == null) {
                createView();
            }
            this.diT.setClickable(true);
            this.isShowing = true;
            if (this.bau.getParent() == null) {
                d.ad(this.mRootView).a(this.mRootView, this.bau, false);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bau.setVisibility(0);
                    a.this.diQ.startAnimation(loadAnimation);
                }
            }, 100L);
            this.diU.setData(this.forumList);
            this.diU.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").ax("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Yu() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bau != null && this.mRootView != null) {
                this.bau.setVisibility(8);
                if (this.bau.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bau);
                }
            }
        }
    }

    public void onDestroy() {
        Yu();
        if (this.diV != null) {
            this.diV.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.diR, e.d.cp_cont_d);
        al.h(this.atD, e.d.cp_cont_d);
        al.j(this.diS, e.d.cp_bg_line_c);
        al.h(this.diT, e.d.common_color_10310);
        al.i(this.diT, e.f.bule_bg_commen_label_button);
        al.i(this.bau, e.d.black_alpha50);
        al.i(this.diQ, e.f.bg_recommend_forum_by_tag);
        this.diU.notifyDataSetChanged();
    }

    public View atX() {
        return this.bau;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
