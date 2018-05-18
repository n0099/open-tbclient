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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdListView FH;
    private View aIw;
    private TextView adw;
    private ViewEventCenter cHX;
    private View cJS;
    private TextView cJT;
    private View cJU;
    private TextView cJV;
    private c cJW;
    private MultiConcernModel cJX;
    private MultiConcernModel.a cJY;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2 != a.this.aIw) {
                if (view2 != a.this.cJT) {
                    if (view2 == a.this.cJV) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new al("c12239").ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.w(arrayList)) {
                            a.this.OI();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.hg()) {
                            l.showToast(a.this.mContext.getPageActivity(), d.k.neterror);
                            return;
                        } else {
                            a.this.cJV.setClickable(false);
                            if (a.this.cJX == null) {
                                a.this.cJX = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.cJY == null) {
                                a.this.cJY = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void O(int i, String str) {
                                        a.this.cJV.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.OI();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cHX != null) {
                                            a.this.cHX.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cJX.a(a.this.cJY);
                            }
                            a.this.cJX.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.OI();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new al("c12240").ac("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.cHX = viewEventCenter;
        }
    }

    private void createView() {
        this.aIw = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cJS = this.aIw.findViewById(d.g.rec_forum_list_container);
        this.cJT = (TextView) this.aIw.findViewById(d.g.view_skip);
        this.adw = (TextView) this.aIw.findViewById(d.g.view_recommend_tip);
        this.cJU = this.aIw.findViewById(d.g.view_top_divider);
        this.FH = (BdListView) this.aIw.findViewById(d.g.listview_forums);
        this.cJV = (TextView) this.aIw.findViewById(d.g.view_forums_concern);
        this.cJV.setClickable(true);
        this.cJW = new c(this.mContext.getPageActivity());
        this.FH.setAdapter((ListAdapter) this.cJW);
        this.FH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (v.c(a.this.forumList, i) != null) {
                    ((b) v.c(a.this.forumList, i)).isSelected = !((b) v.c(a.this.forumList, i)).isSelected;
                    a.this.cJW.setData(a.this.forumList);
                    a.this.cJW.notifyDataSetChanged();
                }
            }
        });
        this.cJT.setOnClickListener(this.mClickListener);
        this.cJV.setOnClickListener(this.mClickListener);
        this.aIw.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aR(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.w(list)) {
                OI();
                return;
            }
            if (this.aIw == null) {
                createView();
            }
            this.cJV.setClickable(true);
            this.isShowing = true;
            if (this.aIw.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.aIw, false);
            }
            e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aIw.setVisibility(0);
                    a.this.cJS.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cJW.setData(this.forumList);
            this.cJW.notifyDataSetChanged();
            TiebaStatic.log(new al("c12238").ac("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void OI() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aIw != null && this.mRootView != null) {
                this.aIw.setVisibility(8);
                if (this.aIw.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aIw);
                }
            }
        }
    }

    public void onDestroy() {
        OI();
        if (this.cJX != null) {
            this.cJX.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        ak.h(this.cJT, d.C0126d.cp_cont_d);
        ak.h(this.adw, d.C0126d.cp_cont_d);
        ak.j(this.cJU, d.C0126d.cp_bg_line_c);
        ak.h(this.cJV, d.C0126d.common_color_10310);
        ak.i(this.cJV, d.f.bule_bg_commen_label_button);
        ak.i(this.aIw, d.C0126d.black_alpha50);
        ak.i(this.cJS, d.f.bg_recommend_forum_by_tag);
        this.cJW.notifyDataSetChanged();
    }

    public View aln() {
        return this.aIw;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
