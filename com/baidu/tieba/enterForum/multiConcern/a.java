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
    private BdListView HO;
    private View aGr;
    private ViewGroup aaE;
    private TextView abE;
    private TbPageContext<?> abm;
    private ViewEventCenter cbZ;
    private TextView cdA;
    private View cdB;
    private TextView cdC;
    private c cdD;
    private MultiConcernModel cdE;
    private MultiConcernModel.a cdF;
    private View cdz;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aOR = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aGr) {
                if (view != a.this.cdA) {
                    if (view == a.this.cdC) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("fid", sb.toString()));
                        if (v.u(arrayList)) {
                            a.this.adm();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hy()) {
                            l.showToast(a.this.abm.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.cdC.setClickable(false);
                            if (a.this.cdE == null) {
                                a.this.cdE = new MultiConcernModel(a.this.abm);
                            }
                            if (a.this.cdF == null) {
                                a.this.cdF = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void x(int i, String str) {
                                        a.this.cdC.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.abm.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.adm();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cbZ != null) {
                                            a.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cdE.a(a.this.cdF);
                            }
                            a.this.cdE.B(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.adm();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.abm = tbPageContext;
            this.aaE = viewGroup;
            this.cbZ = viewEventCenter;
        }
    }

    private void adi() {
        this.aGr = LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cdz = this.aGr.findViewById(d.h.rec_forum_list_container);
        this.cdA = (TextView) this.aGr.findViewById(d.h.view_skip);
        this.abE = (TextView) this.aGr.findViewById(d.h.view_recommend_tip);
        this.cdB = this.aGr.findViewById(d.h.view_top_divider);
        this.HO = (BdListView) this.aGr.findViewById(d.h.listview_forums);
        this.cdC = (TextView) this.aGr.findViewById(d.h.view_forums_concern);
        this.cdC.setClickable(true);
        this.cdD = new c(this.abm.getPageActivity());
        this.HO.setAdapter((ListAdapter) this.cdD);
        this.HO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cdD.setData(a.this.forumList);
                    a.this.cdD.notifyDataSetChanged();
                }
            }
        });
        this.cdA.setOnClickListener(this.aOR);
        this.cdC.setOnClickListener(this.aOR);
        this.aGr.setOnClickListener(this.aOR);
        onChangeSkinType();
    }

    public void au(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.aaE != null) {
            if (v.u(list)) {
                adm();
                return;
            }
            if (this.aGr == null) {
                adi();
            }
            this.cdC.setClickable(true);
            this.isShowing = true;
            if (this.aGr.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.aaE).a(this.aaE, this.aGr, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.abm.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aGr.setVisibility(0);
                    a.this.cdz.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cdD.setData(this.forumList);
            this.cdD.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void adm() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aGr != null && this.aaE != null) {
                this.aGr.setVisibility(8);
                if (this.aGr.getParent() == this.aaE) {
                    this.aaE.removeView(this.aGr);
                }
            }
        }
    }

    public void onDestroy() {
        adm();
        if (this.cdE != null) {
            this.cdE.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cdA, d.e.cp_cont_d);
        aj.i(this.abE, d.e.cp_cont_d);
        aj.k(this.cdB, d.e.cp_bg_line_c);
        aj.i(this.cdC, d.e.common_color_10310);
        aj.j(this.cdC, d.g.bule_bg_commen_label_button);
        aj.j(this.aGr, d.e.black_alpha50);
        aj.j(this.cdz, d.g.bg_recommend_forum_by_tag);
        this.cdD.notifyDataSetChanged();
    }

    public View adn() {
        return this.aGr;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
