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
    private BdListView JC;
    private ViewGroup abK;
    private TextView acG;
    private TbPageContext<?> acp;
    private ViewEventCenter bXK;
    private View bZk;
    private View bZl;
    private TextView bZm;
    private View bZn;
    private TextView bZo;
    private c bZp;
    private MultiConcernModel bZq;
    private MultiConcernModel.a bZr;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener aYW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bZk) {
                if (view != a.this.bZm) {
                    if (view == a.this.bZo) {
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
                            a.this.acb();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!k.hI()) {
                            k.showToast(a.this.acp.getPageActivity(), d.l.neterror);
                            return;
                        } else {
                            a.this.bZo.setClickable(false);
                            if (a.this.bZq == null) {
                                a.this.bZq = new MultiConcernModel(a.this.acp);
                            }
                            if (a.this.bZr == null) {
                                a.this.bZr = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void z(int i, String str) {
                                        a.this.bZo.setClickable(true);
                                        if (i != 0) {
                                            k.showToast(a.this.acp.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.acb();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.bXK != null) {
                                            a.this.bXK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.bZq.a(a.this.bZr);
                            }
                            a.this.bZq.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.acb();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new aj("c12240").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.acp = tbPageContext;
            this.abK = viewGroup;
            this.bXK = viewEventCenter;
        }
    }

    private void abX() {
        this.bZk = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.bZl = this.bZk.findViewById(d.h.rec_forum_list_container);
        this.bZm = (TextView) this.bZk.findViewById(d.h.view_skip);
        this.acG = (TextView) this.bZk.findViewById(d.h.view_recommend_tip);
        this.bZn = this.bZk.findViewById(d.h.view_top_divider);
        this.JC = (BdListView) this.bZk.findViewById(d.h.listview_forums);
        this.bZo = (TextView) this.bZk.findViewById(d.h.view_forums_concern);
        this.bZo.setClickable(true);
        this.bZp = new c(this.acp.getPageActivity());
        this.JC.setAdapter((ListAdapter) this.bZp);
        this.JC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (u.c(a.this.forumList, i) != null) {
                    ((b) u.c(a.this.forumList, i)).isSelected = !((b) u.c(a.this.forumList, i)).isSelected;
                    a.this.bZp.setData(a.this.forumList);
                    a.this.bZp.notifyDataSetChanged();
                }
            }
        });
        this.bZm.setOnClickListener(this.aYW);
        this.bZo.setOnClickListener(this.aYW);
        this.bZk.setOnClickListener(this.aYW);
        onChangeSkinType();
    }

    public void au(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.abK != null) {
            if (u.v(list)) {
                acb();
                return;
            }
            if (this.bZk == null) {
                abX();
            }
            this.bZo.setClickable(true);
            this.isShowing = true;
            if (this.bZk.getParent() == null) {
                com.baidu.tbadk.k.d.K(this.abK).a(this.abK, this.bZk, false);
            }
            e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.acp.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bZk.setVisibility(0);
                    a.this.bZl.startAnimation(loadAnimation);
                }
            }, 100L);
            this.bZp.setData(this.forumList);
            this.bZp.notifyDataSetChanged();
            TiebaStatic.log(new aj("c12238").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void acb() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bZk != null && this.abK != null) {
                this.bZk.setVisibility(8);
                if (this.bZk.getParent() == this.abK) {
                    this.abK.removeView(this.bZk);
                }
            }
        }
    }

    public void onDestroy() {
        acb();
        if (this.bZq != null) {
            this.bZq.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        ai.i(this.bZm, d.e.cp_cont_d);
        ai.i(this.acG, d.e.cp_cont_d);
        ai.k(this.bZn, d.e.cp_bg_line_c);
        ai.i(this.bZo, d.e.common_color_10310);
        ai.j(this.bZo, d.g.bule_bg_commen_label_button);
        ai.j(this.bZk, d.e.black_alpha50);
        ai.j(this.bZl, d.g.bg_recommend_forum_by_tag);
        this.bZp.notifyDataSetChanged();
    }

    public View acc() {
        return this.bZk;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
