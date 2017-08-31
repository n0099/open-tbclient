package com.baidu.tieba.enterForum.multiConcern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdListView Hw;
    private View aHg;
    private ViewGroup aaQ;
    private TextView abP;
    private TbPageContext<?> aby;
    private ViewEventCenter cbt;
    private View ccS;
    private TextView ccT;
    private View ccU;
    private TextView ccV;
    private c ccW;
    private MultiConcernModel ccX;
    private MultiConcernModel.a ccY;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aYK = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHg) {
                if (view != a.this.ccT) {
                    if (view == a.this.ccV) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", sb.toString()));
                        if (v.v(arrayList)) {
                            a.this.ads();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!k.hz()) {
                            k.showToast(a.this.aby.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.ccV.setClickable(false);
                            if (a.this.ccX == null) {
                                a.this.ccX = new MultiConcernModel(a.this.aby);
                            }
                            if (a.this.ccY == null) {
                                a.this.ccY = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void y(int i, String str) {
                                        a.this.ccV.setClickable(true);
                                        if (i != 0) {
                                            k.showToast(a.this.aby.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.ads();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cbt != null) {
                                            a.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.ccX.a(a.this.ccY);
                            }
                            a.this.ccX.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.ads();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aby = tbPageContext;
            this.aaQ = viewGroup;
            this.cbt = viewEventCenter;
        }
    }

    private void ado() {
        this.aHg = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.ccS = this.aHg.findViewById(d.h.rec_forum_list_container);
        this.ccT = (TextView) this.aHg.findViewById(d.h.view_skip);
        this.abP = (TextView) this.aHg.findViewById(d.h.view_recommend_tip);
        this.ccU = this.aHg.findViewById(d.h.view_top_divider);
        this.Hw = (BdListView) this.aHg.findViewById(d.h.listview_forums);
        this.ccV = (TextView) this.aHg.findViewById(d.h.view_forums_concern);
        this.ccV.setClickable(true);
        this.ccW = new c(this.aby.getPageActivity());
        this.Hw.setAdapter((ListAdapter) this.ccW);
        this.Hw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.ccW.setData(a.this.forumList);
                    a.this.ccW.notifyDataSetChanged();
                }
            }
        });
        this.ccT.setOnClickListener(this.aYK);
        this.ccV.setOnClickListener(this.aYK);
        this.aHg.setOnClickListener(this.aYK);
        onChangeSkinType();
    }

    public void av(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.aaQ != null) {
            if (v.v(list)) {
                ads();
                return;
            }
            if (this.aHg == null) {
                ado();
            }
            this.ccV.setClickable(true);
            this.isShowing = true;
            if (this.aHg.getParent() == null) {
                com.baidu.tbadk.k.d.P(this.aaQ).a(this.aaQ, this.aHg, false);
            }
            e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aby.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHg.setVisibility(0);
                    a.this.ccS.startAnimation(loadAnimation);
                }
            }, 100L);
            this.ccW.setData(this.forumList);
            this.ccW.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void ads() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHg != null && this.aaQ != null) {
                this.aHg.setVisibility(8);
                if (this.aHg.getParent() == this.aaQ) {
                    this.aaQ.removeView(this.aHg);
                }
            }
        }
    }

    public void onDestroy() {
        ads();
        if (this.ccX != null) {
            this.ccX.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.ccT, d.e.cp_cont_d);
        aj.i(this.abP, d.e.cp_cont_d);
        aj.k(this.ccU, d.e.cp_bg_line_c);
        aj.i(this.ccV, d.e.common_color_10310);
        aj.j(this.ccV, d.g.bule_bg_commen_label_button);
        aj.j(this.aHg, d.e.black_alpha50);
        aj.j(this.ccS, d.g.bg_recommend_forum_by_tag);
        this.ccW.notifyDataSetChanged();
    }

    public View adt() {
        return this.aHg;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
