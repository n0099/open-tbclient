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
    private TextView bOn;
    private View cxK;
    private ViewEventCenter eVo;
    private View eYI;
    private TextView eYJ;
    private View eYK;
    private TextView eYL;
    private c eYM;
    private MultiConcernModel eYN;
    private MultiConcernModel.a eYO;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cxK) {
                if (view != a.this.eYJ) {
                    if (view == a.this.eYL) {
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
                            a.this.aIk();
                            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.kt()) {
                            l.showToast(a.this.mContext.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.eYL.setClickable(false);
                            if (a.this.eYN == null) {
                                a.this.eYN = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.eYO == null) {
                                a.this.eYO = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ah(int i, String str) {
                                        a.this.eYL.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aIk();
                                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.eVo != null) {
                                            a.this.eVo.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.eYN.a(a.this.eYO);
                            }
                            a.this.eYN.O(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aIk();
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("show_recommend_forums_window_", false);
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
            this.eVo = viewEventCenter;
        }
    }

    private void createView() {
        this.cxK = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.eYI = this.cxK.findViewById(R.id.rec_forum_list_container);
        this.eYJ = (TextView) this.cxK.findViewById(R.id.view_skip);
        this.bOn = (TextView) this.cxK.findViewById(R.id.view_recommend_tip);
        this.eYK = this.cxK.findViewById(R.id.view_top_divider);
        this.Ni = (BdListView) this.cxK.findViewById(R.id.listview_forums);
        this.eYL = (TextView) this.cxK.findViewById(R.id.view_forums_concern);
        this.eYL.setClickable(true);
        this.eYM = new c(this.mContext.getPageActivity());
        this.Ni.setAdapter((ListAdapter) this.eYM);
        this.Ni.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.eYM.setData(a.this.forumList);
                    a.this.eYM.notifyDataSetChanged();
                }
            }
        });
        this.eYJ.setOnClickListener(this.mClickListener);
        this.eYL.setOnClickListener(this.mClickListener);
        this.cxK.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bG(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.aa(list)) {
                aIk();
                return;
            }
            if (this.cxK == null) {
                createView();
            }
            this.eYL.setClickable(true);
            this.isShowing = true;
            if (this.cxK.getParent() == null) {
                e.bg(this.mRootView).a(this.mRootView, this.cxK, false);
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cxK.setVisibility(0);
                    a.this.eYI.startAnimation(loadAnimation);
                }
            }, 100L);
            this.eYM.setData(this.forumList);
            this.eYM.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").bT("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aIk() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.cxK != null && this.mRootView != null) {
                this.cxK.setVisibility(8);
                if (this.cxK.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cxK);
                }
            }
        }
    }

    public void onDestroy() {
        aIk();
        if (this.eYN != null) {
            this.eYN.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.j(this.eYJ, R.color.cp_cont_d);
        am.j(this.bOn, R.color.cp_cont_d);
        am.l(this.eYK, R.color.cp_bg_line_c);
        am.j(this.eYL, R.color.common_color_10310);
        am.k(this.eYL, R.drawable.bule_bg_commen_label_button);
        am.k(this.cxK, R.color.black_alpha50);
        am.k(this.eYI, R.drawable.bg_recommend_forum_by_tag);
        this.eYM.notifyDataSetChanged();
    }

    public View bgt() {
        return this.cxK;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
