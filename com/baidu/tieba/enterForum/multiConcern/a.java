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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private BdListView Hj;
    private View aHj;
    private TbPageContext<?> abI;
    private TextView acd;
    private ViewEventCenter cjP;
    private View cln;
    private TextView clo;
    private View clp;
    private TextView clq;
    private c clr;
    private MultiConcernModel cls;
    private MultiConcernModel.a clt;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHj) {
                if (view != a.this.clo) {
                    if (view == a.this.clq) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.v(arrayList)) {
                            a.this.afH();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hy()) {
                            l.showToast(a.this.abI.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.clq.setClickable(false);
                            if (a.this.cls == null) {
                                a.this.cls = new MultiConcernModel(a.this.abI);
                            }
                            if (a.this.clt == null) {
                                a.this.clt = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void z(int i, String str) {
                                        a.this.clq.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.abI.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.afH();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cjP != null) {
                                            a.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cls.a(a.this.clt);
                            }
                            a.this.cls.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.afH();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.abI = tbPageContext;
            this.mRootView = viewGroup;
            this.cjP = viewEventCenter;
        }
    }

    private void createView() {
        this.aHj = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cln = this.aHj.findViewById(d.g.rec_forum_list_container);
        this.clo = (TextView) this.aHj.findViewById(d.g.view_skip);
        this.acd = (TextView) this.aHj.findViewById(d.g.view_recommend_tip);
        this.clp = this.aHj.findViewById(d.g.view_top_divider);
        this.Hj = (BdListView) this.aHj.findViewById(d.g.listview_forums);
        this.clq = (TextView) this.aHj.findViewById(d.g.view_forums_concern);
        this.clq.setClickable(true);
        this.clr = new c(this.abI.getPageActivity());
        this.Hj.setAdapter((ListAdapter) this.clr);
        this.Hj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.clr.setData(a.this.forumList);
                    a.this.clr.notifyDataSetChanged();
                }
            }
        });
        this.clo.setOnClickListener(this.mClickListener);
        this.clq.setOnClickListener(this.mClickListener);
        this.aHj.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aw(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.v(list)) {
                afH();
                return;
            }
            if (this.aHj == null) {
                createView();
            }
            this.clq.setClickable(true);
            this.isShowing = true;
            if (this.aHj.getParent() == null) {
                com.baidu.tbadk.k.d.Q(this.mRootView).a(this.mRootView, this.aHj, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.abI.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHj.setVisibility(0);
                    a.this.cln.startAnimation(loadAnimation);
                }
            }, 100L);
            this.clr.setData(this.forumList);
            this.clr.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void afH() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHj != null && this.mRootView != null) {
                this.aHj.setVisibility(8);
                if (this.aHj.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aHj);
                }
            }
        }
    }

    public void onDestroy() {
        afH();
        if (this.cls != null) {
            this.cls.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.clo, d.C0080d.cp_cont_d);
        aj.i(this.acd, d.C0080d.cp_cont_d);
        aj.k(this.clp, d.C0080d.cp_bg_line_c);
        aj.i(this.clq, d.C0080d.common_color_10310);
        aj.j(this.clq, d.f.bule_bg_commen_label_button);
        aj.j(this.aHj, d.C0080d.black_alpha50);
        aj.j(this.cln, d.f.bg_recommend_forum_by_tag);
        this.clr.notifyDataSetChanged();
    }

    public View afI() {
        return this.aHj;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
