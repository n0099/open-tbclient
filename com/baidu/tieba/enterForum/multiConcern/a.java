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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private BdListView LQ;
    private View aQX;
    private TextView alu;
    private ViewEventCenter cRe;
    private View cSY;
    private TextView cSZ;
    private View cTa;
    private TextView cTb;
    private c cTc;
    private MultiConcernModel cTd;
    private MultiConcernModel.a cTe;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.aQX) {
                if (view != a.this.cSZ) {
                    if (view == a.this.cTb) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new am("c12239").ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (w.z(arrayList)) {
                            a.this.Sg();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.jU()) {
                            l.showToast(a.this.mContext.getPageActivity(), d.k.neterror);
                            return;
                        } else {
                            a.this.cTb.setClickable(false);
                            if (a.this.cTd == null) {
                                a.this.cTd = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.cTe == null) {
                                a.this.cTe = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void O(int i, String str) {
                                        a.this.cTb.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Sg();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.cRe != null) {
                                            a.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.cTd.a(a.this.cTe);
                            }
                            a.this.cTd.D(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Sg();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new am("c12240").ah("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private TbPageContext<?> mContext;
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.mContext = tbPageContext;
            this.mRootView = viewGroup;
            this.cRe = viewEventCenter;
        }
    }

    private void createView() {
        this.aQX = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.cSY = this.aQX.findViewById(d.g.rec_forum_list_container);
        this.cSZ = (TextView) this.aQX.findViewById(d.g.view_skip);
        this.alu = (TextView) this.aQX.findViewById(d.g.view_recommend_tip);
        this.cTa = this.aQX.findViewById(d.g.view_top_divider);
        this.LQ = (BdListView) this.aQX.findViewById(d.g.listview_forums);
        this.cTb = (TextView) this.aQX.findViewById(d.g.view_forums_concern);
        this.cTb.setClickable(true);
        this.cTc = new c(this.mContext.getPageActivity());
        this.LQ.setAdapter((ListAdapter) this.cTc);
        this.LQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (w.c(a.this.forumList, i) != null) {
                    ((b) w.c(a.this.forumList, i)).isSelected = !((b) w.c(a.this.forumList, i)).isSelected;
                    a.this.cTc.setData(a.this.forumList);
                    a.this.cTc.notifyDataSetChanged();
                }
            }
        });
        this.cSZ.setOnClickListener(this.mClickListener);
        this.cTb.setOnClickListener(this.mClickListener);
        this.aQX.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aU(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (w.z(list)) {
                Sg();
                return;
            }
            if (this.aQX == null) {
                createView();
            }
            this.cTb.setClickable(true);
            this.isShowing = true;
            if (this.aQX.getParent() == null) {
                com.baidu.tbadk.j.d.Q(this.mRootView).a(this.mRootView, this.aQX, false);
            }
            e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.aQX.setVisibility(0);
                    a.this.cSY.startAnimation(loadAnimation);
                }
            }, 100L);
            this.cTc.setData(this.forumList);
            this.cTc.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").ah("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Sg() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.aQX != null && this.mRootView != null) {
                this.aQX.setVisibility(8);
                if (this.aQX.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.aQX);
                }
            }
        }
    }

    public void onDestroy() {
        Sg();
        if (this.cTd != null) {
            this.cTd.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.cSZ, d.C0141d.cp_cont_d);
        al.h(this.alu, d.C0141d.cp_cont_d);
        al.j(this.cTa, d.C0141d.cp_bg_line_c);
        al.h(this.cTb, d.C0141d.common_color_10310);
        al.i(this.cTb, d.f.bule_bg_commen_label_button);
        al.i(this.aQX, d.C0141d.black_alpha50);
        al.i(this.cSY, d.f.bg_recommend_forum_by_tag);
        this.cTc.notifyDataSetChanged();
    }

    public View apt() {
        return this.aQX;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
