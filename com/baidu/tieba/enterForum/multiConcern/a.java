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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private BdListView Ib;
    private TbPageContext<?> aaS;
    private ViewGroup aan;
    private TextView abj;
    private ViewEventCenter bWE;
    private View bYe;
    private View bYf;
    private TextView bYg;
    private View bYh;
    private TextView bYi;
    private c bYj;
    private MultiConcernModel bYk;
    private MultiConcernModel.a bYl;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aXL = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bYe) {
                if (view != a.this.bYg) {
                    if (view == a.this.bYi) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new aj("c12239").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("fid", sb.toString()));
                        if (u.v(arrayList)) {
                            a.this.abW();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!k.hy()) {
                            k.showToast(a.this.aaS.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.bYi.setClickable(false);
                            if (a.this.bYk == null) {
                                a.this.bYk = new MultiConcernModel(a.this.aaS);
                            }
                            if (a.this.bYl == null) {
                                a.this.bYl = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void z(int i, String str) {
                                        a.this.bYi.setClickable(true);
                                        if (i != 0) {
                                            k.showToast(a.this.aaS.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.abW();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.bWE != null) {
                                            a.this.bWE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.bYk.a(a.this.bYl);
                            }
                            a.this.bYk.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.abW();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new aj("c12240").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aaS = tbPageContext;
            this.aan = viewGroup;
            this.bWE = viewEventCenter;
        }
    }

    private void abS() {
        this.bYe = LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.bYf = this.bYe.findViewById(d.h.rec_forum_list_container);
        this.bYg = (TextView) this.bYe.findViewById(d.h.view_skip);
        this.abj = (TextView) this.bYe.findViewById(d.h.view_recommend_tip);
        this.bYh = this.bYe.findViewById(d.h.view_top_divider);
        this.Ib = (BdListView) this.bYe.findViewById(d.h.listview_forums);
        this.bYi = (TextView) this.bYe.findViewById(d.h.view_forums_concern);
        this.bYi.setClickable(true);
        this.bYj = new c(this.aaS.getPageActivity());
        this.Ib.setAdapter((ListAdapter) this.bYj);
        this.Ib.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (u.c(a.this.forumList, i) != null) {
                    ((b) u.c(a.this.forumList, i)).isSelected = !((b) u.c(a.this.forumList, i)).isSelected;
                    a.this.bYj.setData(a.this.forumList);
                    a.this.bYj.notifyDataSetChanged();
                }
            }
        });
        this.bYg.setOnClickListener(this.aXL);
        this.bYi.setOnClickListener(this.aXL);
        this.bYe.setOnClickListener(this.aXL);
        onChangeSkinType();
    }

    public void au(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.aan != null) {
            if (u.v(list)) {
                abW();
                return;
            }
            if (this.bYe == null) {
                abS();
            }
            this.bYi.setClickable(true);
            this.isShowing = true;
            if (this.bYe.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.aan).a(this.aan, this.bYe, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aaS.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bYe.setVisibility(0);
                    a.this.bYf.startAnimation(loadAnimation);
                }
            }, 100L);
            this.bYj.setData(this.forumList);
            this.bYj.notifyDataSetChanged();
            TiebaStatic.log(new aj("c12238").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void abW() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bYe != null && this.aan != null) {
                this.bYe.setVisibility(8);
                if (this.bYe.getParent() == this.aan) {
                    this.aan.removeView(this.bYe);
                }
            }
        }
    }

    public void onDestroy() {
        abW();
        if (this.bYk != null) {
            this.bYk.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.bYg, d.e.cp_cont_d);
        ai.i(this.abj, d.e.cp_cont_d);
        ai.k(this.bYh, d.e.cp_bg_line_c);
        ai.i(this.bYi, d.e.common_color_10310);
        ai.j(this.bYi, d.g.bule_bg_commen_label_button);
        ai.j(this.bYe, d.e.black_alpha50);
        ai.j(this.bYf, d.g.bg_recommend_forum_by_tag);
        this.bYj.notifyDataSetChanged();
    }

    public View abX() {
        return this.bYe;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
