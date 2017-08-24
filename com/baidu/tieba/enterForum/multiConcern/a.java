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
    private BdListView JE;
    private ViewGroup abM;
    private TextView acI;
    private TbPageContext<?> acr;
    private ViewEventCenter bYx;
    private View bZX;
    private View bZY;
    private TextView bZZ;
    private View caa;
    private TextView cab;
    private c cac;
    private MultiConcernModel cad;
    private MultiConcernModel.a cae;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aYY = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bZX) {
                if (view != a.this.bZZ) {
                    if (view == a.this.cab) {
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
                            a.this.acs();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!k.hI()) {
                            k.showToast(a.this.acr.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.cab.setClickable(false);
                            if (a.this.cad == null) {
                                a.this.cad = new MultiConcernModel(a.this.acr);
                            }
                            if (a.this.cae == null) {
                                a.this.cae = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void z(int i, String str) {
                                        a.this.cab.setClickable(true);
                                        if (i != 0) {
                                            k.showToast(a.this.acr.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.acs();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.bYx != null) {
                                            a.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cad.a(a.this.cae);
                            }
                            a.this.cad.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.acs();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new aj("c12240").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.acr = tbPageContext;
            this.abM = viewGroup;
            this.bYx = viewEventCenter;
        }
    }

    private void aco() {
        this.bZX = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.bZY = this.bZX.findViewById(d.h.rec_forum_list_container);
        this.bZZ = (TextView) this.bZX.findViewById(d.h.view_skip);
        this.acI = (TextView) this.bZX.findViewById(d.h.view_recommend_tip);
        this.caa = this.bZX.findViewById(d.h.view_top_divider);
        this.JE = (BdListView) this.bZX.findViewById(d.h.listview_forums);
        this.cab = (TextView) this.bZX.findViewById(d.h.view_forums_concern);
        this.cab.setClickable(true);
        this.cac = new c(this.acr.getPageActivity());
        this.JE.setAdapter((ListAdapter) this.cac);
        this.JE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (u.c(a.this.forumList, i) != null) {
                    ((b) u.c(a.this.forumList, i)).isSelected = !((b) u.c(a.this.forumList, i)).isSelected;
                    a.this.cac.setData(a.this.forumList);
                    a.this.cac.notifyDataSetChanged();
                }
            }
        });
        this.bZZ.setOnClickListener(this.aYY);
        this.cab.setOnClickListener(this.aYY);
        this.bZX.setOnClickListener(this.aYY);
        onChangeSkinType();
    }

    public void au(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.abM != null) {
            if (u.v(list)) {
                acs();
                return;
            }
            if (this.bZX == null) {
                aco();
            }
            this.cab.setClickable(true);
            this.isShowing = true;
            if (this.bZX.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.abM).a(this.abM, this.bZX, false);
            }
            e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.acr.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bZX.setVisibility(0);
                    a.this.bZY.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cac.setData(this.forumList);
            this.cac.notifyDataSetChanged();
            TiebaStatic.log(new aj("c12238").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void acs() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bZX != null && this.abM != null) {
                this.bZX.setVisibility(8);
                if (this.bZX.getParent() == this.abM) {
                    this.abM.removeView(this.bZX);
                }
            }
        }
    }

    public void onDestroy() {
        acs();
        if (this.cad != null) {
            this.cad.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.bZZ, d.e.cp_cont_d);
        ai.i(this.acI, d.e.cp_cont_d);
        ai.k(this.caa, d.e.cp_bg_line_c);
        ai.i(this.cab, d.e.common_color_10310);
        ai.j(this.cab, d.g.bule_bg_commen_label_button);
        ai.j(this.bZX, d.e.black_alpha50);
        ai.j(this.bZY, d.g.bg_recommend_forum_by_tag);
        this.cac.notifyDataSetChanged();
    }

    public View act() {
        return this.bZX;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
