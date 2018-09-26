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
/* loaded from: classes2.dex */
public class a {
    private BdListView Op;
    private View aVh;
    private TextView anY;
    private ViewEventCenter cXw;
    private c cZA;
    private MultiConcernModel cZB;
    private MultiConcernModel.a cZC;
    private View cZw;
    private TextView cZx;
    private View cZy;
    private TextView cZz;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aVh) {
                if (view != a.this.cZx) {
                    if (view == a.this.cZz) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").al("uid", TbadkCoreApplication.getCurrentAccount()).al(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.z(arrayList)) {
                            a.this.UC();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.lb()) {
                            l.showToast(a.this.mContext.getPageActivity(), e.j.neterror);
                            return;
                        } else {
                            a.this.cZz.setClickable(false);
                            if (a.this.cZB == null) {
                                a.this.cZB = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.cZC == null) {
                                a.this.cZC = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void N(int i, String str) {
                                        a.this.cZz.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.UC();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cXw != null) {
                                            a.this.cXw.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cZB.a(a.this.cZC);
                            }
                            a.this.cZB.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.UC();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").al("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.cXw = viewEventCenter;
        }
    }

    private void createView() {
        this.aVh = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cZw = this.aVh.findViewById(e.g.rec_forum_list_container);
        this.cZx = (TextView) this.aVh.findViewById(e.g.view_skip);
        this.anY = (TextView) this.aVh.findViewById(e.g.view_recommend_tip);
        this.cZy = this.aVh.findViewById(e.g.view_top_divider);
        this.Op = (BdListView) this.aVh.findViewById(e.g.listview_forums);
        this.cZz = (TextView) this.aVh.findViewById(e.g.view_forums_concern);
        this.cZz.setClickable(true);
        this.cZA = new c(this.mContext.getPageActivity());
        this.Op.setAdapter((ListAdapter) this.cZA);
        this.Op.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.cZA.setData(a.this.forumList);
                    a.this.cZA.notifyDataSetChanged();
                }
            }
        });
        this.cZx.setOnClickListener(this.mClickListener);
        this.cZz.setOnClickListener(this.mClickListener);
        this.aVh.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aV(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.z(list)) {
                UC();
                return;
            }
            if (this.aVh == null) {
                createView();
            }
            this.cZz.setClickable(true);
            this.isShowing = true;
            if (this.aVh.getParent() == null) {
                d.ae(this.mRootView).a(this.mRootView, this.aVh, false);
            }
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aVh.setVisibility(0);
                    a.this.cZw.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cZA.setData(this.forumList);
            this.cZA.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").al("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void UC() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aVh != null && this.mRootView != null) {
                this.aVh.setVisibility(8);
                if (this.aVh.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aVh);
                }
            }
        }
    }

    public void onDestroy() {
        UC();
        if (this.cZB != null) {
            this.cZB.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.cZx, e.d.cp_cont_d);
        al.h(this.anY, e.d.cp_cont_d);
        al.j(this.cZy, e.d.cp_bg_line_c);
        al.h(this.cZz, e.d.common_color_10310);
        al.i(this.cZz, e.f.bule_bg_commen_label_button);
        al.i(this.aVh, e.d.black_alpha50);
        al.i(this.cZw, e.f.bg_recommend_forum_by_tag);
        this.cZA.notifyDataSetChanged();
    }

    public View arc() {
        return this.aVh;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
