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
    private BdListView Hh;
    private View aHP;
    private TbPageContext<?> abX;
    private TextView acs;
    private ViewEventCenter csF;
    private View cuc;
    private TextView cud;
    private View cue;
    private TextView cuf;
    private c cug;
    private MultiConcernModel cuh;
    private MultiConcernModel.a cui;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHP) {
                if (view != a.this.cud) {
                    if (view == a.this.cuf) {
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
                            l.showToast(a.this.abX.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.cuf.setClickable(false);
                            if (a.this.cuh == null) {
                                a.this.cuh = new MultiConcernModel(a.this.abX);
                            }
                            if (a.this.cui == null) {
                                a.this.cui = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void C(int i, String str) {
                                        a.this.cuf.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.abX.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Od();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.csF != null) {
                                            a.this.csF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cuh.a(a.this.cui);
                            }
                            a.this.cuh.D(arrayList);
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
            this.abX = tbPageContext;
            this.mRootView = viewGroup;
            this.csF = viewEventCenter;
        }
    }

    private void createView() {
        this.aHP = LayoutInflater.from(this.abX.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cuc = this.aHP.findViewById(d.g.rec_forum_list_container);
        this.cud = (TextView) this.aHP.findViewById(d.g.view_skip);
        this.acs = (TextView) this.aHP.findViewById(d.g.view_recommend_tip);
        this.cue = this.aHP.findViewById(d.g.view_top_divider);
        this.Hh = (BdListView) this.aHP.findViewById(d.g.listview_forums);
        this.cuf = (TextView) this.aHP.findViewById(d.g.view_forums_concern);
        this.cuf.setClickable(true);
        this.cug = new c(this.abX.getPageActivity());
        this.Hh.setAdapter((ListAdapter) this.cug);
        this.Hh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cug.setData(a.this.forumList);
                    a.this.cug.notifyDataSetChanged();
                }
            }
        });
        this.cud.setOnClickListener(this.mClickListener);
        this.cuf.setOnClickListener(this.mClickListener);
        this.aHP.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aI(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.w(list)) {
                Od();
                return;
            }
            if (this.aHP == null) {
                createView();
            }
            this.cuf.setClickable(true);
            this.isShowing = true;
            if (this.aHP.getParent() == null) {
                com.baidu.tbadk.j.d.R(this.mRootView).a(this.mRootView, this.aHP, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.abX.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHP.setVisibility(0);
                    a.this.cuc.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cug.setData(this.forumList);
            this.cug.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Od() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHP != null && this.mRootView != null) {
                this.aHP.setVisibility(8);
                if (this.aHP.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aHP);
                }
            }
        }
    }

    public void onDestroy() {
        Od();
        if (this.cuh != null) {
            this.cuh.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.cud, d.C0096d.cp_cont_d);
        aj.i(this.acs, d.C0096d.cp_cont_d);
        aj.k(this.cue, d.C0096d.cp_bg_line_c);
        aj.i(this.cuf, d.C0096d.common_color_10310);
        aj.j(this.cuf, d.f.bule_bg_commen_label_button);
        aj.j(this.aHP, d.C0096d.black_alpha50);
        aj.j(this.cuc, d.f.bg_recommend_forum_by_tag);
        this.cug.notifyDataSetChanged();
    }

    public View ahB() {
        return this.aHP;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
