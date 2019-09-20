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
    private BdListView Nj;
    private TextView bOT;
    private View cyN;
    private ViewEventCenter eXb;
    private View faC;
    private TextView faD;
    private View faE;
    private TextView faF;
    private c faG;
    private MultiConcernModel faH;
    private MultiConcernModel.a faI;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cyN) {
                if (view != a.this.faD) {
                    if (view == a.this.faF) {
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
                            a.this.aIQ();
                            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.kt()) {
                            l.showToast(a.this.mContext.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.faF.setClickable(false);
                            if (a.this.faH == null) {
                                a.this.faH = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.faI == null) {
                                a.this.faI = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ah(int i, String str) {
                                        a.this.faF.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aIQ();
                                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eXb != null) {
                                            a.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.faH.a(a.this.faI);
                            }
                            a.this.faH.O(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aIQ();
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("show_recommend_forums_window_", false);
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
            this.eXb = viewEventCenter;
        }
    }

    private void createView() {
        this.cyN = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.faC = this.cyN.findViewById(R.id.rec_forum_list_container);
        this.faD = (TextView) this.cyN.findViewById(R.id.view_skip);
        this.bOT = (TextView) this.cyN.findViewById(R.id.view_recommend_tip);
        this.faE = this.cyN.findViewById(R.id.view_top_divider);
        this.Nj = (BdListView) this.cyN.findViewById(R.id.listview_forums);
        this.faF = (TextView) this.cyN.findViewById(R.id.view_forums_concern);
        this.faF.setClickable(true);
        this.faG = new c(this.mContext.getPageActivity());
        this.Nj.setAdapter((ListAdapter) this.faG);
        this.Nj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.faG.setData(a.this.forumList);
                    a.this.faG.notifyDataSetChanged();
                }
            }
        });
        this.faD.setOnClickListener(this.mClickListener);
        this.faF.setOnClickListener(this.mClickListener);
        this.cyN.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bG(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.aa(list)) {
                aIQ();
                return;
            }
            if (this.cyN == null) {
                createView();
            }
            this.faF.setClickable(true);
            this.isShowing = true;
            if (this.cyN.getParent() == null) {
                e.bg(this.mRootView).a(this.mRootView, this.cyN, false);
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cyN.setVisibility(0);
                    a.this.faC.startAnimation(loadAnimation);
                }
            }, 100L);
            this.faG.setData(this.forumList);
            this.faG.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aIQ() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.cyN != null && this.mRootView != null) {
                this.cyN.setVisibility(8);
                if (this.cyN.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cyN);
                }
            }
        }
    }

    public void onDestroy() {
        aIQ();
        if (this.faH != null) {
            this.faH.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.j(this.faD, R.color.cp_cont_d);
        am.j(this.bOT, R.color.cp_cont_d);
        am.l(this.faE, R.color.cp_bg_line_c);
        am.j(this.faF, R.color.common_color_10310);
        am.k(this.faF, R.drawable.bule_bg_commen_label_button);
        am.k(this.cyN, R.color.black_alpha50);
        am.k(this.faC, R.drawable.bg_recommend_forum_by_tag);
        this.faG.notifyDataSetChanged();
    }

    public View bhc() {
        return this.cyN;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
