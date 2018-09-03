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
import com.baidu.tbadk.k.d;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdListView LO;
    private View aRR;
    private TextView alt;
    private ViewEventCenter cRF;
    private View cTF;
    private TextView cTG;
    private View cTH;
    private TextView cTI;
    private c cTJ;
    private MultiConcernModel cTK;
    private MultiConcernModel.a cTL;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aRR) {
                if (view != a.this.cTG) {
                    if (view == a.this.cTI) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new an("c12239").ae("uid", TbadkCoreApplication.getCurrentAccount()).ae(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (w.z(arrayList)) {
                            a.this.SP();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.jV()) {
                            l.showToast(a.this.mContext.getPageActivity(), f.j.neterror);
                            return;
                        } else {
                            a.this.cTI.setClickable(false);
                            if (a.this.cTK == null) {
                                a.this.cTK = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.cTL == null) {
                                a.this.cTL = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void N(int i, String str) {
                                        a.this.cTI.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.SP();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cRF != null) {
                                            a.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cTK.a(a.this.cTL);
                            }
                            a.this.cTK.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.SP();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new an("c12240").ae("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.cRF = viewEventCenter;
        }
    }

    private void createView() {
        this.aRR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cTF = this.aRR.findViewById(f.g.rec_forum_list_container);
        this.cTG = (TextView) this.aRR.findViewById(f.g.view_skip);
        this.alt = (TextView) this.aRR.findViewById(f.g.view_recommend_tip);
        this.cTH = this.aRR.findViewById(f.g.view_top_divider);
        this.LO = (BdListView) this.aRR.findViewById(f.g.listview_forums);
        this.cTI = (TextView) this.aRR.findViewById(f.g.view_forums_concern);
        this.cTI.setClickable(true);
        this.cTJ = new c(this.mContext.getPageActivity());
        this.LO.setAdapter((ListAdapter) this.cTJ);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (w.d(a.this.forumList, i) != null) {
                    ((b) w.d(a.this.forumList, i)).isSelected = !((b) w.d(a.this.forumList, i)).isSelected;
                    a.this.cTJ.setData(a.this.forumList);
                    a.this.cTJ.notifyDataSetChanged();
                }
            }
        });
        this.cTG.setOnClickListener(this.mClickListener);
        this.cTI.setOnClickListener(this.mClickListener);
        this.aRR.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aU(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (w.z(list)) {
                SP();
                return;
            }
            if (this.aRR == null) {
                createView();
            }
            this.cTI.setClickable(true);
            this.isShowing = true;
            if (this.aRR.getParent() == null) {
                d.R(this.mRootView).a(this.mRootView, this.aRR, false);
            }
            e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), f.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aRR.setVisibility(0);
                    a.this.cTF.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cTJ.setData(this.forumList);
            this.cTJ.notifyDataSetChanged();
            TiebaStatic.log(new an("c12238").ae("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void SP() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aRR != null && this.mRootView != null) {
                this.aRR.setVisibility(8);
                if (this.aRR.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aRR);
                }
            }
        }
    }

    public void onDestroy() {
        SP();
        if (this.cTK != null) {
            this.cTK.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        am.h(this.cTG, f.d.cp_cont_d);
        am.h(this.alt, f.d.cp_cont_d);
        am.j(this.cTH, f.d.cp_bg_line_c);
        am.h(this.cTI, f.d.common_color_10310);
        am.i(this.cTI, f.C0146f.bule_bg_commen_label_button);
        am.i(this.aRR, f.d.black_alpha50);
        am.i(this.cTF, f.C0146f.bg_recommend_forum_by_tag);
        this.cTJ.notifyDataSetChanged();
    }

    public View apo() {
        return this.aRR;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
