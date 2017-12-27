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
/* loaded from: classes2.dex */
public class a {
    private TextView aQI;
    private TbPageContext<?> aQq;
    private BdListView avk;
    private View bvG;
    private ViewEventCenter dhh;
    private View diD;
    private TextView diE;
    private View diF;
    private TextView diG;
    private c diH;
    private MultiConcernModel diI;
    private MultiConcernModel.a diJ;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bvG) {
                if (view != a.this.diE) {
                    if (view == a.this.diG) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.G(arrayList)) {
                            a.this.VC();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.oZ()) {
                            l.showToast(a.this.aQq.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.diG.setClickable(false);
                            if (a.this.diI == null) {
                                a.this.diI = new MultiConcernModel(a.this.aQq);
                            }
                            if (a.this.diJ == null) {
                                a.this.diJ = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void B(int i, String str) {
                                        a.this.diG.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aQq.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.VC();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dhh != null) {
                                            a.this.dhh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.diI.a(a.this.diJ);
                            }
                            a.this.diI.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.VC();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aQq = tbPageContext;
            this.mRootView = viewGroup;
            this.dhh = viewEventCenter;
        }
    }

    private void createView() {
        this.bvG = LayoutInflater.from(this.aQq.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.diD = this.bvG.findViewById(d.g.rec_forum_list_container);
        this.diE = (TextView) this.bvG.findViewById(d.g.view_skip);
        this.aQI = (TextView) this.bvG.findViewById(d.g.view_recommend_tip);
        this.diF = this.bvG.findViewById(d.g.view_top_divider);
        this.avk = (BdListView) this.bvG.findViewById(d.g.listview_forums);
        this.diG = (TextView) this.bvG.findViewById(d.g.view_forums_concern);
        this.diG.setClickable(true);
        this.diH = new c(this.aQq.getPageActivity());
        this.avk.setAdapter((ListAdapter) this.diH);
        this.avk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.f(a.this.forumList, i) != null) {
                    ((b) v.f(a.this.forumList, i)).isSelected = !((b) v.f(a.this.forumList, i)).isSelected;
                    a.this.diH.setData(a.this.forumList);
                    a.this.diH.notifyDataSetChanged();
                }
            }
        });
        this.diE.setOnClickListener(this.mClickListener);
        this.diG.setOnClickListener(this.mClickListener);
        this.bvG.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aT(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.G(list)) {
                VC();
                return;
            }
            if (this.bvG == null) {
                createView();
            }
            this.diG.setClickable(true);
            this.isShowing = true;
            if (this.bvG.getParent() == null) {
                com.baidu.tbadk.j.d.bj(this.mRootView).a(this.mRootView, this.bvG, false);
            }
            e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aQq.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bvG.setVisibility(0);
                    a.this.diD.startAnimation(loadAnimation);
                }
            }, 100L);
            this.diH.setData(this.forumList);
            this.diH.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void VC() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bvG != null && this.mRootView != null) {
                this.bvG.setVisibility(8);
                if (this.bvG.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bvG);
                }
            }
        }
    }

    public void onDestroy() {
        VC();
        if (this.diI != null) {
            this.diI.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.diE, d.C0108d.cp_cont_d);
        aj.r(this.aQI, d.C0108d.cp_cont_d);
        aj.t(this.diF, d.C0108d.cp_bg_line_c);
        aj.r(this.diG, d.C0108d.common_color_10310);
        aj.s(this.diG, d.f.bule_bg_commen_label_button);
        aj.s(this.bvG, d.C0108d.black_alpha50);
        aj.s(this.diD, d.f.bg_recommend_forum_by_tag);
        this.diH.notifyDataSetChanged();
    }

    public View apb() {
        return this.bvG;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
