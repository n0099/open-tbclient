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
/* loaded from: classes6.dex */
public class a {
    private BdListView Ak;
    private TbPageContext<?> cQU;
    private View dxc;
    private ViewEventCenter fNE;
    private View fQZ;
    private TextView fRa;
    private View fRb;
    private TextView fRc;
    private c fRd;
    private MultiConcernModel fRe;
    private MultiConcernModel.a fRf;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.dxc) {
                if (view != a.this.fRa) {
                    if (view == a.this.fRc) {
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
                            a.this.bwn();
                            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                            return;
                        } else if (!l.isNetOk()) {
                            l.showToast(a.this.cQU.getPageActivity(), (int) R.string.neterror);
                            return;
                        } else {
                            a.this.fRc.setClickable(false);
                            if (a.this.fRe == null) {
                                a.this.fRe = new MultiConcernModel(a.this.cQU);
                            }
                            if (a.this.fRf == null) {
                                a.this.fRf = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void av(int i, String str) {
                                        a.this.fRc.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.cQU.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.bwn();
                                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                                        if (a.this.fNE != null) {
                                            a.this.fNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.fRe.a(a.this.fRf);
                            }
                            a.this.fRe.ae(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.bwn();
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.SHOW_RECOMMEND_FORUMS_WINDOW, false);
                TiebaStatic.log(new an("c12240").cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;
    private TextView mTipView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.cQU = tbPageContext;
            this.mRootView = viewGroup;
            this.fNE = viewEventCenter;
        }
    }

    private void createView() {
        this.dxc = LayoutInflater.from(this.cQU.getPageActivity()).inflate(R.layout.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.fQZ = this.dxc.findViewById(R.id.rec_forum_list_container);
        this.fRa = (TextView) this.dxc.findViewById(R.id.view_skip);
        this.mTipView = (TextView) this.dxc.findViewById(R.id.view_recommend_tip);
        this.fRb = this.dxc.findViewById(R.id.view_top_divider);
        this.Ak = (BdListView) this.dxc.findViewById(R.id.listview_forums);
        this.fRc = (TextView) this.dxc.findViewById(R.id.view_forums_concern);
        this.fRc.setClickable(true);
        this.fRd = new c(this.cQU.getPageActivity());
        this.Ak.setAdapter((ListAdapter) this.fRd);
        this.Ak.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.getItem(a.this.forumList, i) != null) {
                    ((b) v.getItem(a.this.forumList, i)).isSelected = !((b) v.getItem(a.this.forumList, i)).isSelected;
                    a.this.fRd.setData(a.this.forumList);
                    a.this.fRd.notifyDataSetChanged();
                }
            }
        });
        this.fRa.setOnClickListener(this.mClickListener);
        this.fRc.setOnClickListener(this.mClickListener);
        this.dxc.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bP(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.isEmpty(list)) {
                bwn();
                return;
            }
            if (this.dxc == null) {
                createView();
            }
            this.fRc.setClickable(true);
            this.isShowing = true;
            if (this.dxc.getParent() == null) {
                e.bd(this.mRootView).attachView(this.mRootView, this.dxc, false);
            }
            com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.cQU.getPageActivity(), R.anim.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.dxc.setVisibility(0);
                    a.this.fQZ.startAnimation(loadAnimation);
                }
            }, 100L);
            this.fRd.setData(this.forumList);
            this.fRd.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").cp("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void bwn() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.dxc != null && this.mRootView != null) {
                this.dxc.setVisibility(8);
                if (this.dxc.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.dxc);
                }
            }
        }
    }

    public void onDestroy() {
        bwn();
        if (this.fRe != null) {
            this.fRe.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.fRa, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.fRb, R.color.cp_bg_line_c);
        am.setViewTextColor(this.fRc, (int) R.color.common_color_10310);
        am.setBackgroundResource(this.fRc, R.drawable.bule_bg_commen_label_button);
        am.setBackgroundResource(this.dxc, R.color.black_alpha50);
        am.setBackgroundResource(this.fQZ, R.drawable.bg_recommend_forum_by_tag);
        this.fRd.notifyDataSetChanged();
    }

    public View bwo() {
        return this.dxc;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
