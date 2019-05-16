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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.m.e;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView MS;
    private TextView bNl;
    private View cwu;
    private ViewEventCenter eQn;
    private View eTG;
    private TextView eTH;
    private View eTI;
    private TextView eTJ;
    private c eTK;
    private MultiConcernModel eTL;
    private MultiConcernModel.a eTM;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cwu) {
                if (view != a.this.eTH) {
                    if (view == a.this.eTJ) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("fid", sb.toString()));
                        if (v.aa(arrayList)) {
                            a.this.aGK();
                            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.ki()) {
                            l.showToast(a.this.mContext.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.eTJ.setClickable(false);
                            if (a.this.eTL == null) {
                                a.this.eTL = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eTM == null) {
                                a.this.eTM = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ah(int i, String str) {
                                        a.this.eTJ.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aGK();
                                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eQn != null) {
                                            a.this.eQn.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eTL.a(a.this.eTM);
                            }
                            a.this.eTL.O(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aGK();
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.eQn = viewEventCenter;
        }
    }

    private void createView() {
        this.cwu = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eTG = this.cwu.findViewById(R.id.rec_forum_list_container);
        this.eTH = (TextView) this.cwu.findViewById(R.id.view_skip);
        this.bNl = (TextView) this.cwu.findViewById(R.id.view_recommend_tip);
        this.eTI = this.cwu.findViewById(R.id.view_top_divider);
        this.MS = (BdListView) this.cwu.findViewById(R.id.listview_forums);
        this.eTJ = (TextView) this.cwu.findViewById(R.id.view_forums_concern);
        this.eTJ.setClickable(true);
        this.eTK = new c(this.mContext.getPageActivity());
        this.MS.setAdapter((ListAdapter) this.eTK);
        this.MS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eTK.setData(a.this.forumList);
                    a.this.eTK.notifyDataSetChanged();
                }
            }
        });
        this.eTH.setOnClickListener(this.mClickListener);
        this.eTJ.setOnClickListener(this.mClickListener);
        this.cwu.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bE(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.aa(list)) {
                aGK();
                return;
            }
            if (this.cwu == null) {
                createView();
            }
            this.eTJ.setClickable(true);
            this.isShowing = true;
            if (this.cwu.getParent() == null) {
                e.be(this.mRootView).a(this.mRootView, this.cwu, false);
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cwu.setVisibility(0);
                    a.this.eTG.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eTK.setData(this.forumList);
            this.eTK.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aGK() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.cwu != null && this.mRootView != null) {
                this.cwu.setVisibility(8);
                if (this.cwu.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cwu);
                }
            }
        }
    }

    public void onDestroy() {
        aGK();
        if (this.eTL != null) {
            this.eTL.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eTH, R.color.cp_cont_d);
        al.j(this.bNl, R.color.cp_cont_d);
        al.l(this.eTI, R.color.cp_bg_line_c);
        al.j(this.eTJ, R.color.common_color_10310);
        al.k(this.eTJ, R.drawable.bule_bg_commen_label_button);
        al.k(this.cwu, R.color.black_alpha50);
        al.k(this.eTG, R.drawable.bg_recommend_forum_by_tag);
        this.eTK.notifyDataSetChanged();
    }

    public View ben() {
        return this.cwu;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
