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
    private BdListView Hi;
    private View aHS;
    private TbPageContext<?> aca;
    private TextView acv;
    private ViewEventCenter csJ;
    private View cug;
    private TextView cuh;
    private View cui;
    private TextView cuj;
    private c cuk;
    private MultiConcernModel cul;
    private MultiConcernModel.a cum;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHS) {
                if (view != a.this.cuh) {
                    if (view == a.this.cuj) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.w(arrayList)) {
                            a.this.Od();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hy()) {
                            l.showToast(a.this.aca.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.cuj.setClickable(false);
                            if (a.this.cul == null) {
                                a.this.cul = new MultiConcernModel(a.this.aca);
                            }
                            if (a.this.cum == null) {
                                a.this.cum = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void C(int i, String str) {
                                        a.this.cuj.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aca.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Od();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.csJ != null) {
                                            a.this.csJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cul.a(a.this.cum);
                            }
                            a.this.cul.D(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Od();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ac("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aca = tbPageContext;
            this.mRootView = viewGroup;
            this.csJ = viewEventCenter;
        }
    }

    private void createView() {
        this.aHS = LayoutInflater.from(this.aca.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cug = this.aHS.findViewById(d.g.rec_forum_list_container);
        this.cuh = (TextView) this.aHS.findViewById(d.g.view_skip);
        this.acv = (TextView) this.aHS.findViewById(d.g.view_recommend_tip);
        this.cui = this.aHS.findViewById(d.g.view_top_divider);
        this.Hi = (BdListView) this.aHS.findViewById(d.g.listview_forums);
        this.cuj = (TextView) this.aHS.findViewById(d.g.view_forums_concern);
        this.cuj.setClickable(true);
        this.cuk = new c(this.aca.getPageActivity());
        this.Hi.setAdapter((ListAdapter) this.cuk);
        this.Hi.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cuk.setData(a.this.forumList);
                    a.this.cuk.notifyDataSetChanged();
                }
            }
        });
        this.cuh.setOnClickListener(this.mClickListener);
        this.cuj.setOnClickListener(this.mClickListener);
        this.aHS.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aI(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.w(list)) {
                Od();
                return;
            }
            if (this.aHS == null) {
                createView();
            }
            this.cuj.setClickable(true);
            this.isShowing = true;
            if (this.aHS.getParent() == null) {
                com.baidu.tbadk.j.d.R(this.mRootView).a(this.mRootView, this.aHS, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aca.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHS.setVisibility(0);
                    a.this.cug.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cuk.setData(this.forumList);
            this.cuk.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Od() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHS != null && this.mRootView != null) {
                this.aHS.setVisibility(8);
                if (this.aHS.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aHS);
                }
            }
        }
    }

    public void onDestroy() {
        Od();
        if (this.cul != null) {
            this.cul.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cuh, d.C0095d.cp_cont_d);
        aj.i(this.acv, d.C0095d.cp_cont_d);
        aj.k(this.cui, d.C0095d.cp_bg_line_c);
        aj.i(this.cuj, d.C0095d.common_color_10310);
        aj.j(this.cuj, d.f.bule_bg_commen_label_button);
        aj.j(this.aHS, d.C0095d.black_alpha50);
        aj.j(this.cug, d.f.bg_recommend_forum_by_tag);
        this.cuk.notifyDataSetChanged();
    }

    public View ahA() {
        return this.aHS;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
