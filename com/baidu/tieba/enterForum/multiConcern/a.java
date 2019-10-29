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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private View cKj;
    private TbPageContext<?> cfl;
    private ViewEventCenter eZN;
    private View fdn;
    private TextView fdo;
    private View fdp;
    private TextView fdq;
    private c fdr;
    private MultiConcernModel fds;
    private MultiConcernModel.a fdt;
    private List<b> forumList;
    private ViewGroup mRootView;
    private TextView mTipView;
    private BdListView yl;
    private boolean abS = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cKj) {
                if (view != a.this.fdo) {
                    if (view == a.this.fdq) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new an("c12239").bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fid", sb.toString()));
                        if (v.isEmpty(arrayList)) {
                            a.this.beV();
                            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                            return;
                        } else if (!l.isNetOk()) {
                            l.showToast(a.this.cfl.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.fdq.setClickable(false);
                            if (a.this.fds == null) {
                                a.this.fds = new MultiConcernModel(a.this.cfl);
                            }
                            if (a.this.fdt == null) {
                                a.this.fdt = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ah(int i, String str) {
                                        a.this.fdq.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.cfl.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.beV();
                                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                                        if (a.this.eZN != null) {
                                            a.this.eZN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.fds.a(a.this.fdt);
                            }
                            a.this.fds.T(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.beV();
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                TiebaStatic.log(new an("c12240").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.cfl = tbPageContext;
            this.mRootView = viewGroup;
            this.eZN = viewEventCenter;
        }
    }

    private void nw() {
        this.cKj = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.fdn = this.cKj.findViewById(R.id.rec_forum_list_container);
        this.fdo = (TextView) this.cKj.findViewById(R.id.view_skip);
        this.mTipView = (TextView) this.cKj.findViewById(R.id.view_recommend_tip);
        this.fdp = this.cKj.findViewById(R.id.view_top_divider);
        this.yl = (BdListView) this.cKj.findViewById(R.id.listview_forums);
        this.fdq = (TextView) this.cKj.findViewById(R.id.view_forums_concern);
        this.fdq.setClickable(true);
        this.fdr = new c(this.cfl.getPageActivity());
        this.yl.setAdapter((ListAdapter) this.fdr);
        this.yl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.getItem(a.this.forumList, i) != null) {
                    ((b) v.getItem(a.this.forumList, i)).isSelected = !((b) v.getItem(a.this.forumList, i)).isSelected;
                    a.this.fdr.setData(a.this.forumList);
                    a.this.fdr.notifyDataSetChanged();
                }
            }
        });
        this.fdo.setOnClickListener(this.mClickListener);
        this.fdq.setOnClickListener(this.mClickListener);
        this.cKj.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bT(List<b> list) {
        this.forumList = list;
        if (!this.abS && this.mRootView != null) {
            if (v.isEmpty(list)) {
                beV();
                return;
            }
            if (this.cKj == null) {
                nw();
            }
            this.fdq.setClickable(true);
            this.abS = true;
            if (this.cKj.getParent() == null) {
                e.bg(this.mRootView).attachView(this.mRootView, this.cKj, false);
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.cfl.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cKj.setVisibility(0);
                    a.this.fdn.startAnimation(loadAnimation);
                }
            }, 100L);
            this.fdr.setData(this.forumList);
            this.fdr.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").bS("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void beV() {
        if (this.abS) {
            this.abS = false;
            if (this.cKj != null && this.mRootView != null) {
                this.cKj.setVisibility(8);
                if (this.cKj.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cKj);
                }
            }
        }
    }

    public void onDestroy() {
        beV();
        if (this.fds != null) {
            this.fds.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fdo, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.fdp, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fdq, (int) R.color.common_color_10310);
        am.setBackgroundResource(this.fdq, R.drawable.bule_bg_commen_label_button);
        am.setBackgroundResource(this.cKj, R.color.black_alpha50);
        am.setBackgroundResource(this.fdn, R.drawable.bg_recommend_forum_by_tag);
        this.fdr.notifyDataSetChanged();
    }

    public View beW() {
        return this.cKj;
    }

    public boolean isShowing() {
        return this.abS;
    }
}
