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
    private View aHd;
    private ViewGroup aaQ;
    private TextView abP;
    private TbPageContext<?> aby;
    private ViewEventCenter ccl;
    private View cdK;
    private TextView cdL;
    private View cdM;
    private TextView cdN;
    private c cdO;
    private MultiConcernModel cdP;
    private MultiConcernModel.a cdQ;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aYH = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHd) {
                if (view != a.this.cdL) {
                    if (view == a.this.cdN) {
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
                            a.this.adD();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!k.hz()) {
                            k.showToast(a.this.aby.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.cdN.setClickable(false);
                            if (a.this.cdP == null) {
                                a.this.cdP = new MultiConcernModel(a.this.aby);
                            }
                            if (a.this.cdQ == null) {
                                a.this.cdQ = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void y(int i, String str) {
                                        a.this.cdN.setClickable(true);
                                        if (i != 0) {
                                            k.showToast(a.this.aby.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.adD();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.ccl != null) {
                                            a.this.ccl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cdP.a(a.this.cdQ);
                            }
                            a.this.cdP.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.adD();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aby = tbPageContext;
            this.aaQ = viewGroup;
            this.ccl = viewEventCenter;
        }
    }

    private void adz() {
        this.aHd = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cdK = this.aHd.findViewById(d.h.rec_forum_list_container);
        this.cdL = (TextView) this.aHd.findViewById(d.h.view_skip);
        this.abP = (TextView) this.aHd.findViewById(d.h.view_recommend_tip);
        this.cdM = this.aHd.findViewById(d.h.view_top_divider);
        this.Hw = (BdListView) this.aHd.findViewById(d.h.listview_forums);
        this.cdN = (TextView) this.aHd.findViewById(d.h.view_forums_concern);
        this.cdN.setClickable(true);
        this.cdO = new c(this.aby.getPageActivity());
        this.Hw.setAdapter((ListAdapter) this.cdO);
        this.Hw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cdO.setData(a.this.forumList);
                    a.this.cdO.notifyDataSetChanged();
                }
            }
        });
        this.cdL.setOnClickListener(this.aYH);
        this.cdN.setOnClickListener(this.aYH);
        this.aHd.setOnClickListener(this.aYH);
        onChangeSkinType();
    }

    public void av(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.aaQ != null) {
            if (v.v(list)) {
                adD();
                return;
            }
            if (this.aHd == null) {
                adz();
            }
            this.cdN.setClickable(true);
            this.isShowing = true;
            if (this.aHd.getParent() == null) {
                com.baidu.tbadk.k.d.P(this.aaQ).a(this.aaQ, this.aHd, false);
            }
            e.fQ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aby.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHd.setVisibility(0);
                    a.this.cdK.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cdO.setData(this.forumList);
            this.cdO.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void adD() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHd != null && this.aaQ != null) {
                this.aHd.setVisibility(8);
                if (this.aHd.getParent() == this.aaQ) {
                    this.aaQ.removeView(this.aHd);
                }
            }
        }
    }

    public void onDestroy() {
        adD();
        if (this.cdP != null) {
            this.cdP.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cdL, d.e.cp_cont_d);
        aj.i(this.abP, d.e.cp_cont_d);
        aj.k(this.cdM, d.e.cp_bg_line_c);
        aj.i(this.cdN, d.e.common_color_10310);
        aj.j(this.cdN, d.g.bule_bg_commen_label_button);
        aj.j(this.aHd, d.e.black_alpha50);
        aj.j(this.cdK, d.g.bg_recommend_forum_by_tag);
        this.cdO.notifyDataSetChanged();
    }

    public View adE() {
        return this.aHd;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
