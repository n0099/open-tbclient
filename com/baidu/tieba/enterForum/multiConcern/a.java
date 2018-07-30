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
    private BdListView LO;
    private View aRT;
    private TextView alu;
    private ViewEventCenter cRI;
    private View cTJ;
    private TextView cTK;
    private View cTL;
    private TextView cTM;
    private c cTN;
    private MultiConcernModel cTO;
    private MultiConcernModel.a cTP;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aRT) {
                if (view != a.this.cTK) {
                    if (view == a.this.cTM) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new an("c12239").af("uid", TbadkCoreApplication.getCurrentAccount()).af(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (w.z(arrayList)) {
                            a.this.SL();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.jV()) {
                            l.showToast(a.this.mContext.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.cTM.setClickable(false);
                            if (a.this.cTO == null) {
                                a.this.cTO = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.cTP == null) {
                                a.this.cTP = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void N(int i, String str) {
                                        a.this.cTM.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.SL();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cRI != null) {
                                            a.this.cRI.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cTO.a(a.this.cTP);
                            }
                            a.this.cTO.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.SL();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new an("c12240").af("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.cRI = viewEventCenter;
        }
    }

    private void createView() {
        this.aRT = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cTJ = this.aRT.findViewById(d.g.rec_forum_list_container);
        this.cTK = (TextView) this.aRT.findViewById(d.g.view_skip);
        this.alu = (TextView) this.aRT.findViewById(d.g.view_recommend_tip);
        this.cTL = this.aRT.findViewById(d.g.view_top_divider);
        this.LO = (BdListView) this.aRT.findViewById(d.g.listview_forums);
        this.cTM = (TextView) this.aRT.findViewById(d.g.view_forums_concern);
        this.cTM.setClickable(true);
        this.cTN = new c(this.mContext.getPageActivity());
        this.LO.setAdapter((ListAdapter) this.cTN);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (w.d(a.this.forumList, i) != null) {
                    ((b) w.d(a.this.forumList, i)).isSelected = !((b) w.d(a.this.forumList, i)).isSelected;
                    a.this.cTN.setData(a.this.forumList);
                    a.this.cTN.notifyDataSetChanged();
                }
            }
        });
        this.cTK.setOnClickListener(this.mClickListener);
        this.cTM.setOnClickListener(this.mClickListener);
        this.aRT.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aU(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (w.z(list)) {
                SL();
                return;
            }
            if (this.aRT == null) {
                createView();
            }
            this.cTM.setClickable(true);
            this.isShowing = true;
            if (this.aRT.getParent() == null) {
                com.baidu.tbadk.k.d.R(this.mRootView).a(this.mRootView, this.aRT, false);
            }
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aRT.setVisibility(0);
                    a.this.cTJ.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cTN.setData(this.forumList);
            this.cTN.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").af("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void SL() {
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
        SL();
        if (this.cTO != null) {
            this.cTO.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.h(this.cTK, d.C0140d.cp_cont_d);
        am.h(this.alu, d.C0140d.cp_cont_d);
        am.j(this.cTL, d.C0140d.cp_bg_line_c);
        am.h(this.cTM, d.C0140d.common_color_10310);
        am.i(this.cTM, d.f.bule_bg_commen_label_button);
        am.i(this.aRT, d.C0140d.black_alpha50);
        am.i(this.cTJ, d.f.bg_recommend_forum_by_tag);
        this.cTN.notifyDataSetChanged();
    }

    public View apo() {
        return this.aRT;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
