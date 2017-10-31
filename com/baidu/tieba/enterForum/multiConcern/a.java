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
    private View aHb;
    private TbPageContext<?> abI;
    private TextView acd;
    private ViewEventCenter cjC;
    private View ckU;
    private TextView ckV;
    private View ckW;
    private TextView ckX;
    private c ckY;
    private MultiConcernModel ckZ;
    private MultiConcernModel.a cla;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aHb) {
                if (view != a.this.ckV) {
                    if (view == a.this.ckX) {
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
                            a.this.aft();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hy()) {
                            l.showToast(a.this.abI.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.ckX.setClickable(false);
                            if (a.this.ckZ == null) {
                                a.this.ckZ = new MultiConcernModel(a.this.abI);
                            }
                            if (a.this.cla == null) {
                                a.this.cla = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void z(int i, String str) {
                                        a.this.ckX.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.abI.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.aft();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cjC != null) {
                                            a.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.ckZ.a(a.this.cla);
                            }
                            a.this.ckZ.C(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.aft();
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
            this.cjC = viewEventCenter;
        }
    }

    private void createView() {
        this.aHb = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.ckU = this.aHb.findViewById(d.g.rec_forum_list_container);
        this.ckV = (TextView) this.aHb.findViewById(d.g.view_skip);
        this.acd = (TextView) this.aHb.findViewById(d.g.view_recommend_tip);
        this.ckW = this.aHb.findViewById(d.g.view_top_divider);
        this.Hj = (BdListView) this.aHb.findViewById(d.g.listview_forums);
        this.ckX = (TextView) this.aHb.findViewById(d.g.view_forums_concern);
        this.ckX.setClickable(true);
        this.ckY = new c(this.abI.getPageActivity());
        this.Hj.setAdapter((ListAdapter) this.ckY);
        this.Hj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.ckY.setData(a.this.forumList);
                    a.this.ckY.notifyDataSetChanged();
                }
            }
        });
        this.ckV.setOnClickListener(this.mClickListener);
        this.ckX.setOnClickListener(this.mClickListener);
        this.aHb.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aw(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.v(list)) {
                aft();
                return;
            }
            if (this.aHb == null) {
                createView();
            }
            this.ckX.setClickable(true);
            this.isShowing = true;
            if (this.aHb.getParent() == null) {
                com.baidu.tbadk.k.d.Q(this.mRootView).a(this.mRootView, this.aHb, false);
            }
            e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.abI.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aHb.setVisibility(0);
                    a.this.ckU.startAnimation(loadAnimation);
                }
            }, 100L);
            this.ckY.setData(this.forumList);
            this.ckY.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void aft() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aHb != null && this.mRootView != null) {
                this.aHb.setVisibility(8);
                if (this.aHb.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aHb);
                }
            }
        }
    }

    public void onDestroy() {
        aft();
        if (this.ckZ != null) {
            this.ckZ.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.i(this.ckV, d.C0080d.cp_cont_d);
        aj.i(this.acd, d.C0080d.cp_cont_d);
        aj.k(this.ckW, d.C0080d.cp_bg_line_c);
        aj.i(this.ckX, d.C0080d.common_color_10310);
        aj.j(this.ckX, d.f.bule_bg_commen_label_button);
        aj.j(this.aHb, d.C0080d.black_alpha50);
        aj.j(this.ckU, d.f.bg_recommend_forum_by_tag);
        this.ckY.notifyDataSetChanged();
    }

    public View afu() {
        return this.aHb;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
