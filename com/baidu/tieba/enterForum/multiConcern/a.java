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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdListView LS;
    private View aRT;
    private TextView alU;
    private ViewEventCenter cOZ;
    private View cQW;
    private TextView cQX;
    private View cQY;
    private TextView cQZ;
    private c cRa;
    private MultiConcernModel cRb;
    private MultiConcernModel.a cRc;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aRT) {
                if (view != a.this.cQX) {
                    if (view == a.this.cQZ) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new an("c12239").ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (w.A(arrayList)) {
                            a.this.SC();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.jU()) {
                            l.showToast(a.this.mContext.getPageActivity(), d.k.neterror);
                            return;
                        } else {
                            a.this.cQZ.setClickable(false);
                            if (a.this.cRb == null) {
                                a.this.cRb = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.cRc == null) {
                                a.this.cRc = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void L(int i, String str) {
                                        a.this.cQZ.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.SC();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cOZ != null) {
                                            a.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cRb.a(a.this.cRc);
                            }
                            a.this.cRb.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.SC();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new an("c12240").ah("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.cOZ = viewEventCenter;
        }
    }

    private void createView() {
        this.aRT = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cQW = this.aRT.findViewById(d.g.rec_forum_list_container);
        this.cQX = (TextView) this.aRT.findViewById(d.g.view_skip);
        this.alU = (TextView) this.aRT.findViewById(d.g.view_recommend_tip);
        this.cQY = this.aRT.findViewById(d.g.view_top_divider);
        this.LS = (BdListView) this.aRT.findViewById(d.g.listview_forums);
        this.cQZ = (TextView) this.aRT.findViewById(d.g.view_forums_concern);
        this.cQZ.setClickable(true);
        this.cRa = new c(this.mContext.getPageActivity());
        this.LS.setAdapter((ListAdapter) this.cRa);
        this.LS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (w.d(a.this.forumList, i) != null) {
                    ((b) w.d(a.this.forumList, i)).isSelected = !((b) w.d(a.this.forumList, i)).isSelected;
                    a.this.cRa.setData(a.this.forumList);
                    a.this.cRa.notifyDataSetChanged();
                }
            }
        });
        this.cQX.setOnClickListener(this.mClickListener);
        this.cQZ.setOnClickListener(this.mClickListener);
        this.aRT.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aV(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (w.A(list)) {
                SC();
                return;
            }
            if (this.aRT == null) {
                createView();
            }
            this.cQZ.setClickable(true);
            this.isShowing = true;
            if (this.aRT.getParent() == null) {
                com.baidu.tbadk.j.d.R(this.mRootView).a(this.mRootView, this.aRT, false);
            }
            e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aRT.setVisibility(0);
                    a.this.cQW.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cRa.setData(this.forumList);
            this.cRa.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").ah("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void SC() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aRT != null && this.mRootView != null) {
                this.aRT.setVisibility(8);
                if (this.aRT.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aRT);
                }
            }
        }
    }

    public void onDestroy() {
        SC();
        if (this.cRb != null) {
            this.cRb.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.h(this.cQX, d.C0142d.cp_cont_d);
        am.h(this.alU, d.C0142d.cp_cont_d);
        am.j(this.cQY, d.C0142d.cp_bg_line_c);
        am.h(this.cQZ, d.C0142d.common_color_10310);
        am.i(this.cQZ, d.f.bule_bg_commen_label_button);
        am.i(this.aRT, d.C0142d.black_alpha50);
        am.i(this.cQW, d.f.bg_recommend_forum_by_tag);
        this.cRa.notifyDataSetChanged();
    }

    public View aoN() {
        return this.aRT;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
