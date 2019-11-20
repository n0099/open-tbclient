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
    private View cJs;
    private TbPageContext<?> ceu;
    private ViewEventCenter eYW;
    private c fcA;
    private MultiConcernModel fcB;
    private MultiConcernModel.a fcC;
    private View fcw;
    private TextView fcx;
    private View fcy;
    private TextView fcz;
    private List<b> forumList;
    private ViewGroup mRootView;
    private TextView mTipView;
    private BdListView xL;
    private boolean abA = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.cJs) {
                if (view != a.this.fcx) {
                    if (view == a.this.fcz) {
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
                            a.this.beT();
                            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                            return;
                        } else if (!l.isNetOk()) {
                            l.showToast(a.this.ceu.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.fcz.setClickable(false);
                            if (a.this.fcB == null) {
                                a.this.fcB = new MultiConcernModel(a.this.ceu);
                            }
                            if (a.this.fcC == null) {
                                a.this.fcC = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void ag(int i, String str) {
                                        a.this.fcz.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.ceu.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.beT();
                                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                                        if (a.this.eYW != null) {
                                            a.this.eYW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.fcB.a(a.this.fcC);
                            }
                            a.this.fcB.T(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.beT();
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                TiebaStatic.log(new an("c12240").bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.ceu = tbPageContext;
            this.mRootView = viewGroup;
            this.eYW = viewEventCenter;
        }
    }

    private void nw() {
        this.cJs = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.fcw = this.cJs.findViewById(R.id.rec_forum_list_container);
        this.fcx = (TextView) this.cJs.findViewById(R.id.view_skip);
        this.mTipView = (TextView) this.cJs.findViewById(R.id.view_recommend_tip);
        this.fcy = this.cJs.findViewById(R.id.view_top_divider);
        this.xL = (BdListView) this.cJs.findViewById(R.id.listview_forums);
        this.fcz = (TextView) this.cJs.findViewById(R.id.view_forums_concern);
        this.fcz.setClickable(true);
        this.fcA = new c(this.ceu.getPageActivity());
        this.xL.setAdapter((ListAdapter) this.fcA);
        this.xL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.getItem(a.this.forumList, i) != null) {
                    ((b) v.getItem(a.this.forumList, i)).isSelected = !((b) v.getItem(a.this.forumList, i)).isSelected;
                    a.this.fcA.setData(a.this.forumList);
                    a.this.fcA.notifyDataSetChanged();
                }
            }
        });
        this.fcx.setOnClickListener(this.mClickListener);
        this.fcz.setOnClickListener(this.mClickListener);
        this.cJs.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bT(List<b> list) {
        this.forumList = list;
        if (!this.abA && this.mRootView != null) {
            if (v.isEmpty(list)) {
                beT();
                return;
            }
            if (this.cJs == null) {
                nw();
            }
            this.fcz.setClickable(true);
            this.abA = true;
            if (this.cJs.getParent() == null) {
                e.bg(this.mRootView).attachView(this.mRootView, this.cJs, false);
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.ceu.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.cJs.setVisibility(0);
                    a.this.fcw.startAnimation(loadAnimation);
                }
            }, 100L);
            this.fcA.setData(this.forumList);
            this.fcA.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").bS("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void beT() {
        if (this.abA) {
            this.abA = false;
            if (this.cJs != null && this.mRootView != null) {
                this.cJs.setVisibility(8);
                if (this.cJs.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.cJs);
                }
            }
        }
    }

    public void onDestroy() {
        beT();
        if (this.fcB != null) {
            this.fcB.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fcx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.fcy, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fcz, (int) R.color.common_color_10310);
        am.setBackgroundResource(this.fcz, R.drawable.bule_bg_commen_label_button);
        am.setBackgroundResource(this.cJs, R.color.black_alpha50);
        am.setBackgroundResource(this.fcw, R.drawable.bg_recommend_forum_by_tag);
        this.fcA.notifyDataSetChanged();
    }

    public View beU() {
        return this.cJs;
    }

    public boolean isShowing() {
        return this.abA;
    }
}
