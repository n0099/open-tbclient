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
    private ViewEventCenter bYw;
    private View bZW;
    private View bZX;
    private TextView bZY;
    private View bZZ;
    private TextView caa;
    private c cab;
    private MultiConcernModel cac;
    private MultiConcernModel.a cad;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aYX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bZW) {
                if (view != a.this.bZY) {
                    if (view == a.this.caa) {
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
                            a.this.acw();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!k.hI()) {
                            k.showToast(a.this.acr.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.caa.setClickable(false);
                            if (a.this.cac == null) {
                                a.this.cac = new MultiConcernModel(a.this.acr);
                            }
                            if (a.this.cad == null) {
                                a.this.cad = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void z(int i, String str) {
                                        a.this.caa.setClickable(true);
                                        if (i != 0) {
                                            k.showToast(a.this.acr.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.acw();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.bYw != null) {
                                            a.this.bYw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cac.a(a.this.cad);
                            }
                            a.this.cac.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.acw();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new aj("c12240").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.acr = tbPageContext;
            this.abM = viewGroup;
            this.bYw = viewEventCenter;
        }
    }

    private void acs() {
        this.bZW = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.bZX = this.bZW.findViewById(d.h.rec_forum_list_container);
        this.bZY = (TextView) this.bZW.findViewById(d.h.view_skip);
        this.acI = (TextView) this.bZW.findViewById(d.h.view_recommend_tip);
        this.bZZ = this.bZW.findViewById(d.h.view_top_divider);
        this.JE = (BdListView) this.bZW.findViewById(d.h.listview_forums);
        this.caa = (TextView) this.bZW.findViewById(d.h.view_forums_concern);
        this.caa.setClickable(true);
        this.cab = new c(this.acr.getPageActivity());
        this.JE.setAdapter((ListAdapter) this.cab);
        this.JE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (u.c(a.this.forumList, i) != null) {
                    ((b) u.c(a.this.forumList, i)).isSelected = !((b) u.c(a.this.forumList, i)).isSelected;
                    a.this.cab.setData(a.this.forumList);
                    a.this.cab.notifyDataSetChanged();
                }
            }
        });
        this.bZY.setOnClickListener(this.aYX);
        this.caa.setOnClickListener(this.aYX);
        this.bZW.setOnClickListener(this.aYX);
        onChangeSkinType();
    }

    public void au(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.abM != null) {
            if (u.v(list)) {
                acw();
                return;
            }
            if (this.bZW == null) {
                acs();
            }
            this.caa.setClickable(true);
            this.isShowing = true;
            if (this.bZW.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.abM).a(this.abM, this.bZW, false);
            }
            e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.acr.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bZW.setVisibility(0);
                    a.this.bZX.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cab.setData(this.forumList);
            this.cab.notifyDataSetChanged();
            TiebaStatic.log(new aj("c12238").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void acw() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bZW != null && this.abM != null) {
                this.bZW.setVisibility(8);
                if (this.bZW.getParent() == this.abM) {
                    this.abM.removeView(this.bZW);
                }
            }
        }
    }

    public void onDestroy() {
        acw();
        if (this.cac != null) {
            this.cac.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.bZY, d.e.cp_cont_d);
        ai.i(this.acI, d.e.cp_cont_d);
        ai.k(this.bZZ, d.e.cp_bg_line_c);
        ai.i(this.caa, d.e.common_color_10310);
        ai.j(this.caa, d.g.bule_bg_commen_label_button);
        ai.j(this.bZW, d.e.black_alpha50);
        ai.j(this.bZX, d.g.bg_recommend_forum_by_tag);
        this.cab.notifyDataSetChanged();
    }

    public View acx() {
        return this.bZW;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
