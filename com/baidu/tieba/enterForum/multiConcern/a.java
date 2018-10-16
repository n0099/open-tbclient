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
    private BdListView OE;
    private View aZG;
    private TextView asQ;
    private ViewEventCenter dfO;
    private View dhL;
    private TextView dhM;
    private View dhN;
    private TextView dhO;
    private c dhP;
    private MultiConcernModel dhQ;
    private MultiConcernModel.a dhR;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aZG) {
                if (view != a.this.dhM) {
                    if (view == a.this.dhO) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.J(arrayList)) {
                            a.this.Yj();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.lo()) {
                            l.showToast(a.this.mContext.getPageActivity(), e.j.neterror);
                            return;
                        } else {
                            a.this.dhO.setClickable(false);
                            if (a.this.dhQ == null) {
                                a.this.dhQ = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.dhR == null) {
                                a.this.dhR = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void N(int i, String str) {
                                        a.this.dhO.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Yj();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dfO != null) {
                                            a.this.dfO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dhQ.a(a.this.dhR);
                            }
                            a.this.dhQ.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Yj();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.dfO = viewEventCenter;
        }
    }

    private void createView() {
        this.aZG = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dhL = this.aZG.findViewById(e.g.rec_forum_list_container);
        this.dhM = (TextView) this.aZG.findViewById(e.g.view_skip);
        this.asQ = (TextView) this.aZG.findViewById(e.g.view_recommend_tip);
        this.dhN = this.aZG.findViewById(e.g.view_top_divider);
        this.OE = (BdListView) this.aZG.findViewById(e.g.listview_forums);
        this.dhO = (TextView) this.aZG.findViewById(e.g.view_forums_concern);
        this.dhO.setClickable(true);
        this.dhP = new c(this.mContext.getPageActivity());
        this.OE.setAdapter((ListAdapter) this.dhP);
        this.OE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.dhP.setData(a.this.forumList);
                    a.this.dhP.notifyDataSetChanged();
                }
            }
        });
        this.dhM.setOnClickListener(this.mClickListener);
        this.dhO.setOnClickListener(this.mClickListener);
        this.aZG.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bl(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.J(list)) {
                Yj();
                return;
            }
            if (this.aZG == null) {
                createView();
            }
            this.dhO.setClickable(true);
            this.isShowing = true;
            if (this.aZG.getParent() == null) {
                d.ae(this.mRootView).a(this.mRootView, this.aZG, false);
            }
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aZG.setVisibility(0);
                    a.this.dhL.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dhP.setData(this.forumList);
            this.dhP.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").ax("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Yj() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aZG != null && this.mRootView != null) {
                this.aZG.setVisibility(8);
                if (this.aZG.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aZG);
                }
            }
        }
    }

    public void onDestroy() {
        Yj();
        if (this.dhQ != null) {
            this.dhQ.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dhM, e.d.cp_cont_d);
        al.h(this.asQ, e.d.cp_cont_d);
        al.j(this.dhN, e.d.cp_bg_line_c);
        al.h(this.dhO, e.d.common_color_10310);
        al.i(this.dhO, e.f.bule_bg_commen_label_button);
        al.i(this.aZG, e.d.black_alpha50);
        al.i(this.dhL, e.f.bg_recommend_forum_by_tag);
        this.dhP.notifyDataSetChanged();
    }

    public View auy() {
        return this.aZG;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
