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
import com.baidu.adp.lib.util.l;
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
    private BdListView HN;
    private View aGE;
    private ViewGroup aaQ;
    private TextView abQ;
    private TbPageContext<?> abz;
    private ViewEventCenter ccl;
    private View cdL;
    private TextView cdM;
    private View cdN;
    private TextView cdO;
    private c cdP;
    private MultiConcernModel cdQ;
    private MultiConcernModel.a cdR;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aPe = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aGE) {
                if (view != a.this.cdM) {
                    if (view == a.this.cdO) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("fid", sb.toString()));
                        if (v.u(arrayList)) {
                            a.this.adq();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hy()) {
                            l.showToast(a.this.abz.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.cdO.setClickable(false);
                            if (a.this.cdQ == null) {
                                a.this.cdQ = new MultiConcernModel(a.this.abz);
                            }
                            if (a.this.cdR == null) {
                                a.this.cdR = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void x(int i, String str) {
                                        a.this.cdO.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.abz.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.adq();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.ccl != null) {
                                            a.this.ccl.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cdQ.a(a.this.cdR);
                            }
                            a.this.cdQ.B(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.adq();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.abz = tbPageContext;
            this.aaQ = viewGroup;
            this.ccl = viewEventCenter;
        }
    }

    private void adm() {
        this.aGE = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cdL = this.aGE.findViewById(d.h.rec_forum_list_container);
        this.cdM = (TextView) this.aGE.findViewById(d.h.view_skip);
        this.abQ = (TextView) this.aGE.findViewById(d.h.view_recommend_tip);
        this.cdN = this.aGE.findViewById(d.h.view_top_divider);
        this.HN = (BdListView) this.aGE.findViewById(d.h.listview_forums);
        this.cdO = (TextView) this.aGE.findViewById(d.h.view_forums_concern);
        this.cdO.setClickable(true);
        this.cdP = new c(this.abz.getPageActivity());
        this.HN.setAdapter((ListAdapter) this.cdP);
        this.HN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cdP.setData(a.this.forumList);
                    a.this.cdP.notifyDataSetChanged();
                }
            }
        });
        this.cdM.setOnClickListener(this.aPe);
        this.cdO.setOnClickListener(this.aPe);
        this.aGE.setOnClickListener(this.aPe);
        onChangeSkinType();
    }

    public void au(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.aaQ != null) {
            if (v.u(list)) {
                adq();
                return;
            }
            if (this.aGE == null) {
                adm();
            }
            this.cdO.setClickable(true);
            this.isShowing = true;
            if (this.aGE.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.aaQ).a(this.aaQ, this.aGE, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.abz.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aGE.setVisibility(0);
                    a.this.cdL.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cdP.setData(this.forumList);
            this.cdP.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void adq() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aGE != null && this.aaQ != null) {
                this.aGE.setVisibility(8);
                if (this.aGE.getParent() == this.aaQ) {
                    this.aaQ.removeView(this.aGE);
                }
            }
        }
    }

    public void onDestroy() {
        adq();
        if (this.cdQ != null) {
            this.cdQ.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cdM, d.e.cp_cont_d);
        aj.i(this.abQ, d.e.cp_cont_d);
        aj.k(this.cdN, d.e.cp_bg_line_c);
        aj.i(this.cdO, d.e.common_color_10310);
        aj.j(this.cdO, d.g.bule_bg_commen_label_button);
        aj.j(this.aGE, d.e.black_alpha50);
        aj.j(this.cdL, d.g.bg_recommend_forum_by_tag);
        this.cdP.notifyDataSetChanged();
    }

    public View adr() {
        return this.aGE;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
