package com.baidu.tieba.enterForum.multiConcern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.k.d;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdListView OF;
    private TextView axe;
    private View bdU;
    private ViewEventCenter dqs;
    private View dsj;
    private TextView dsk;
    private View dsl;
    private TextView dsm;
    private c dsn;
    private MultiConcernModel dso;
    private MultiConcernModel.a dsp;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bdU) {
                if (view != a.this.dsk) {
                    if (view == a.this.dsm) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.I(arrayList)) {
                            a.this.ZC();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.ll()) {
                            l.showToast(a.this.mContext.getPageActivity(), e.j.neterror);
                            return;
                        } else {
                            a.this.dsm.setClickable(false);
                            if (a.this.dso == null) {
                                a.this.dso = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.dsp == null) {
                                a.this.dsp = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void K(int i, String str) {
                                        a.this.dsm.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.ZC();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dqs != null) {
                                            a.this.dqs.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dso.a(a.this.dsp);
                            }
                            a.this.dso.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.ZC();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").aA("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.dqs = viewEventCenter;
        }
    }

    private void createView() {
        this.bdU = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dsj = this.bdU.findViewById(e.g.rec_forum_list_container);
        this.dsk = (TextView) this.bdU.findViewById(e.g.view_skip);
        this.axe = (TextView) this.bdU.findViewById(e.g.view_recommend_tip);
        this.dsl = this.bdU.findViewById(e.g.view_top_divider);
        this.OF = (BdListView) this.bdU.findViewById(e.g.listview_forums);
        this.dsm = (TextView) this.bdU.findViewById(e.g.view_forums_concern);
        this.dsm.setClickable(true);
        this.dsn = new c(this.mContext.getPageActivity());
        this.OF.setAdapter((ListAdapter) this.dsn);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.dsn.setData(a.this.forumList);
                    a.this.dsn.notifyDataSetChanged();
                }
            }
        });
        this.dsk.setOnClickListener(this.mClickListener);
        this.dsm.setOnClickListener(this.mClickListener);
        this.bdU.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bm(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.I(list)) {
                ZC();
                return;
            }
            if (this.bdU == null) {
                createView();
            }
            this.dsm.setClickable(true);
            this.isShowing = true;
            if (this.bdU.getParent() == null) {
                d.ad(this.mRootView).a(this.mRootView, this.bdU, false);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bdU.setVisibility(0);
                    a.this.dsj.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dsn.setData(this.forumList);
            this.dsn.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").aA("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void ZC() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bdU != null && this.mRootView != null) {
                this.bdU.setVisibility(8);
                if (this.bdU.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bdU);
                }
            }
        }
    }

    public void onDestroy() {
        ZC();
        if (this.dso != null) {
            this.dso.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dsk, e.d.cp_cont_d);
        al.h(this.axe, e.d.cp_cont_d);
        al.j(this.dsl, e.d.cp_bg_line_c);
        al.h(this.dsm, e.d.common_color_10310);
        al.i(this.dsm, e.f.bule_bg_commen_label_button);
        al.i(this.bdU, e.d.black_alpha50);
        al.i(this.dsj, e.f.bg_recommend_forum_by_tag);
        this.dsn.notifyDataSetChanged();
    }

    public View awx() {
        return this.bdU;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
