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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView Ni;
    private TextView bOs;
    private View cxR;
    private ViewEventCenter eVv;
    private View eYW;
    private TextView eYX;
    private View eYY;
    private TextView eYZ;
    private c eZa;
    private MultiConcernModel eZb;
    private MultiConcernModel.a eZc;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cxR) {
                if (view != a.this.eYX) {
                    if (view == a.this.eYZ) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new an("c12239").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", sb.toString()));
                        if (v.aa(arrayList)) {
                            a.this.aIm();
                            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.kt()) {
                            l.showToast(a.this.mContext.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.eYZ.setClickable(false);
                            if (a.this.eZb == null) {
                                a.this.eZb = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eZc == null) {
                                a.this.eZc = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ah(int i, String str) {
                                        a.this.eYZ.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aIm();
                                        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eVv != null) {
                                            a.this.eVv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eZb.a(a.this.eZc);
                            }
                            a.this.eZb.O(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aIm();
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new an("c12240").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.eVv = viewEventCenter;
        }
    }

    private void createView() {
        this.cxR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eYW = this.cxR.findViewById(R.id.rec_forum_list_container);
        this.eYX = (TextView) this.cxR.findViewById(R.id.view_skip);
        this.bOs = (TextView) this.cxR.findViewById(R.id.view_recommend_tip);
        this.eYY = this.cxR.findViewById(R.id.view_top_divider);
        this.Ni = (BdListView) this.cxR.findViewById(R.id.listview_forums);
        this.eYZ = (TextView) this.cxR.findViewById(R.id.view_forums_concern);
        this.eYZ.setClickable(true);
        this.eZa = new c(this.mContext.getPageActivity());
        this.Ni.setAdapter((ListAdapter) this.eZa);
        this.Ni.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eZa.setData(a.this.forumList);
                    a.this.eZa.notifyDataSetChanged();
                }
            }
        });
        this.eYX.setOnClickListener(this.mClickListener);
        this.eYZ.setOnClickListener(this.mClickListener);
        this.cxR.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bG(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.aa(list)) {
                aIm();
                return;
            }
            if (this.cxR == null) {
                createView();
            }
            this.eYZ.setClickable(true);
            this.isShowing = true;
            if (this.cxR.getParent() == null) {
                e.bg(this.mRootView).a(this.mRootView, this.cxR, false);
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cxR.setVisibility(0);
                    a.this.eYW.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eZa.setData(this.forumList);
            this.eZa.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aIm() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.cxR != null && this.mRootView != null) {
                this.cxR.setVisibility(8);
                if (this.cxR.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cxR);
                }
            }
        }
    }

    public void onDestroy() {
        aIm();
        if (this.eZb != null) {
            this.eZb.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.j(this.eYX, R.color.cp_cont_d);
        am.j(this.bOs, R.color.cp_cont_d);
        am.l(this.eYY, R.color.cp_bg_line_c);
        am.j(this.eYZ, R.color.common_color_10310);
        am.k(this.eYZ, R.drawable.bule_bg_commen_label_button);
        am.k(this.cxR, R.color.black_alpha50);
        am.k(this.eYW, R.drawable.bg_recommend_forum_by_tag);
        this.eZa.notifyDataSetChanged();
    }

    public View bgw() {
        return this.cxR;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
