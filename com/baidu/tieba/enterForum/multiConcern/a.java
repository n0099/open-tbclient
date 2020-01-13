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
import com.baidu.tbadk.k.e;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private BdListView Ao;
    private TbPageContext<?> cRe;
    private View dxk;
    private ViewEventCenter fQN;
    private View fUj;
    private TextView fUk;
    private View fUl;
    private TextView fUm;
    private c fUn;
    private MultiConcernModel fUo;
    private MultiConcernModel.a fUp;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.dxk) {
                if (view != a.this.fUk) {
                    if (view == a.this.fUm) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new an("c12239").cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fid", sb.toString()));
                        if (v.isEmpty(arrayList)) {
                            a.this.bxp();
                            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                            return;
                        } else if (!l.isNetOk()) {
                            l.showToast(a.this.cRe.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.fUm.setClickable(false);
                            if (a.this.fUo == null) {
                                a.this.fUo = new MultiConcernModel(a.this.cRe);
                            }
                            if (a.this.fUp == null) {
                                a.this.fUp = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void aB(int i, String str) {
                                        a.this.fUm.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.cRe.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.bxp();
                                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                                        if (a.this.fQN != null) {
                                            a.this.fQN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.fUo.a(a.this.fUp);
                            }
                            a.this.fUo.ae(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.bxp();
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                TiebaStatic.log(new an("c12240").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;
    private TextView mTipView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.cRe = tbPageContext;
            this.mRootView = viewGroup;
            this.fQN = viewEventCenter;
        }
    }

    private void createView() {
        this.dxk = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.fUj = this.dxk.findViewById(R.id.rec_forum_list_container);
        this.fUk = (TextView) this.dxk.findViewById(R.id.view_skip);
        this.mTipView = (TextView) this.dxk.findViewById(R.id.view_recommend_tip);
        this.fUl = this.dxk.findViewById(R.id.view_top_divider);
        this.Ao = (BdListView) this.dxk.findViewById(R.id.listview_forums);
        this.fUm = (TextView) this.dxk.findViewById(R.id.view_forums_concern);
        this.fUm.setClickable(true);
        this.fUn = new c(this.cRe.getPageActivity());
        this.Ao.setAdapter((ListAdapter) this.fUn);
        this.Ao.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.getItem(a.this.forumList, i) != null) {
                    ((b) v.getItem(a.this.forumList, i)).isSelected = !((b) v.getItem(a.this.forumList, i)).isSelected;
                    a.this.fUn.setData(a.this.forumList);
                    a.this.fUn.notifyDataSetChanged();
                }
            }
        });
        this.fUk.setOnClickListener(this.mClickListener);
        this.fUm.setOnClickListener(this.mClickListener);
        this.dxk.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bP(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.isEmpty(list)) {
                bxp();
                return;
            }
            if (this.dxk == null) {
                createView();
            }
            this.fUm.setClickable(true);
            this.isShowing = true;
            if (this.dxk.getParent() == null) {
                e.bh(this.mRootView).attachView(this.mRootView, this.dxk, false);
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.cRe.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.dxk.setVisibility(0);
                    a.this.fUj.startAnimation(loadAnimation);
                }
            }, 100L);
            this.fUn.setData(this.forumList);
            this.fUn.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void bxp() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.dxk != null && this.mRootView != null) {
                this.dxk.setVisibility(8);
                if (this.dxk.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.dxk);
                }
            }
        }
    }

    public void onDestroy() {
        bxp();
        if (this.fUo != null) {
            this.fUo.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fUk, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.fUl, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fUm, (int) R.color.common_color_10310);
        am.setBackgroundResource(this.fUm, R.drawable.bule_bg_commen_label_button);
        am.setBackgroundResource(this.dxk, R.color.black_alpha50);
        am.setBackgroundResource(this.fUj, R.drawable.bg_recommend_forum_by_tag);
        this.fUn.notifyDataSetChanged();
    }

    public View bxq() {
        return this.dxk;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
