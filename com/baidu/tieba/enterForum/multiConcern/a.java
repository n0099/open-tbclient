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
    private BdListView MR;
    private TextView bNm;
    private View cwv;
    private ViewEventCenter eQo;
    private View eTH;
    private TextView eTI;
    private View eTJ;
    private TextView eTK;
    private c eTL;
    private MultiConcernModel eTM;
    private MultiConcernModel.a eTN;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cwv) {
                if (view != a.this.eTI) {
                    if (view == a.this.eTK) {
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
                            a.this.aGN();
                            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.ki()) {
                            l.showToast(a.this.mContext.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.eTK.setClickable(false);
                            if (a.this.eTM == null) {
                                a.this.eTM = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eTN == null) {
                                a.this.eTN = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ah(int i, String str) {
                                        a.this.eTK.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aGN();
                                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eQo != null) {
                                            a.this.eQo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eTM.a(a.this.eTN);
                            }
                            a.this.eTM.O(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aGN();
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
            this.eQo = viewEventCenter;
        }
    }

    private void createView() {
        this.cwv = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eTH = this.cwv.findViewById(R.id.rec_forum_list_container);
        this.eTI = (TextView) this.cwv.findViewById(R.id.view_skip);
        this.bNm = (TextView) this.cwv.findViewById(R.id.view_recommend_tip);
        this.eTJ = this.cwv.findViewById(R.id.view_top_divider);
        this.MR = (BdListView) this.cwv.findViewById(R.id.listview_forums);
        this.eTK = (TextView) this.cwv.findViewById(R.id.view_forums_concern);
        this.eTK.setClickable(true);
        this.eTL = new c(this.mContext.getPageActivity());
        this.MR.setAdapter((ListAdapter) this.eTL);
        this.MR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eTL.setData(a.this.forumList);
                    a.this.eTL.notifyDataSetChanged();
                }
            }
        });
        this.eTI.setOnClickListener(this.mClickListener);
        this.eTK.setOnClickListener(this.mClickListener);
        this.cwv.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bE(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.aa(list)) {
                aGN();
                return;
            }
            if (this.cwv == null) {
                createView();
            }
            this.eTK.setClickable(true);
            this.isShowing = true;
            if (this.cwv.getParent() == null) {
                e.be(this.mRootView).a(this.mRootView, this.cwv, false);
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cwv.setVisibility(0);
                    a.this.eTH.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eTL.setData(this.forumList);
            this.eTL.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aGN() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.cwv != null && this.mRootView != null) {
                this.cwv.setVisibility(8);
                if (this.cwv.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cwv);
                }
            }
        }
    }

    public void onDestroy() {
        aGN();
        if (this.eTM != null) {
            this.eTM.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.j(this.eTI, R.color.cp_cont_d);
        al.j(this.bNm, R.color.cp_cont_d);
        al.l(this.eTJ, R.color.cp_bg_line_c);
        al.j(this.eTK, R.color.common_color_10310);
        al.k(this.eTK, R.drawable.bule_bg_commen_label_button);
        al.k(this.cwv, R.color.black_alpha50);
        al.k(this.eTH, R.drawable.bg_recommend_forum_by_tag);
        this.eTL.notifyDataSetChanged();
    }

    public View beq() {
        return this.cwv;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
