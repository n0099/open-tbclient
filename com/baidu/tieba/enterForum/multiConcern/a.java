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
    private View aHL;
    private TbPageContext<?> acd;
    private TextView acy;
    private ViewEventCenter csw;
    private View ctT;
    private TextView ctU;
    private View ctV;
    private TextView ctW;
    private c ctX;
    private MultiConcernModel ctY;
    private MultiConcernModel.a ctZ;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHL) {
                if (view != a.this.ctU) {
                    if (view == a.this.ctW) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.w(arrayList)) {
                            a.this.Od();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hy()) {
                            l.showToast(a.this.acd.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.ctW.setClickable(false);
                            if (a.this.ctY == null) {
                                a.this.ctY = new MultiConcernModel(a.this.acd);
                            }
                            if (a.this.ctZ == null) {
                                a.this.ctZ = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void C(int i, String str) {
                                        a.this.ctW.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.acd.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Od();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.csw != null) {
                                            a.this.csw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.ctY.a(a.this.ctZ);
                            }
                            a.this.ctY.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Od();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.acd = tbPageContext;
            this.mRootView = viewGroup;
            this.csw = viewEventCenter;
        }
    }

    private void createView() {
        this.aHL = LayoutInflater.from(this.acd.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.ctT = this.aHL.findViewById(d.g.rec_forum_list_container);
        this.ctU = (TextView) this.aHL.findViewById(d.g.view_skip);
        this.acy = (TextView) this.aHL.findViewById(d.g.view_recommend_tip);
        this.ctV = this.aHL.findViewById(d.g.view_top_divider);
        this.Hj = (BdListView) this.aHL.findViewById(d.g.listview_forums);
        this.ctW = (TextView) this.aHL.findViewById(d.g.view_forums_concern);
        this.ctW.setClickable(true);
        this.ctX = new c(this.acd.getPageActivity());
        this.Hj.setAdapter((ListAdapter) this.ctX);
        this.Hj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.ctX.setData(a.this.forumList);
                    a.this.ctX.notifyDataSetChanged();
                }
            }
        });
        this.ctU.setOnClickListener(this.mClickListener);
        this.ctW.setOnClickListener(this.mClickListener);
        this.aHL.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aI(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.w(list)) {
                Od();
                return;
            }
            if (this.aHL == null) {
                createView();
            }
            this.ctW.setClickable(true);
            this.isShowing = true;
            if (this.aHL.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.aHL, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.acd.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHL.setVisibility(0);
                    a.this.ctT.startAnimation(loadAnimation);
                }
            }, 100L);
            this.ctX.setData(this.forumList);
            this.ctX.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Od() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHL != null && this.mRootView != null) {
                this.aHL.setVisibility(8);
                if (this.aHL.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aHL);
                }
            }
        }
    }

    public void onDestroy() {
        Od();
        if (this.ctY != null) {
            this.ctY.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.ctU, d.C0082d.cp_cont_d);
        aj.i(this.acy, d.C0082d.cp_cont_d);
        aj.k(this.ctV, d.C0082d.cp_bg_line_c);
        aj.i(this.ctW, d.C0082d.common_color_10310);
        aj.j(this.ctW, d.f.bule_bg_commen_label_button);
        aj.j(this.aHL, d.C0082d.black_alpha50);
        aj.j(this.ctT, d.f.bg_recommend_forum_by_tag);
        this.ctX.notifyDataSetChanged();
    }

    public View aht() {
        return this.aHL;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
