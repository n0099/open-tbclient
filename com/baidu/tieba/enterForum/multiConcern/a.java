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
    private TextView axd;
    private View bdR;
    private ViewEventCenter dnB;
    private View dpt;
    private TextView dpu;
    private View dpv;
    private TextView dpw;
    private c dpx;
    private MultiConcernModel dpy;
    private MultiConcernModel.a dpz;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bdR) {
                if (view != a.this.dpu) {
                    if (view == a.this.dpw) {
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
                            a.this.ZA();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.ll()) {
                            l.showToast(a.this.mContext.getPageActivity(), e.j.neterror);
                            return;
                        } else {
                            a.this.dpw.setClickable(false);
                            if (a.this.dpy == null) {
                                a.this.dpy = new MultiConcernModel(a.this.mContext);
                            }
                            if (a.this.dpz == null) {
                                a.this.dpz = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void J(int i, String str) {
                                        a.this.dpw.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.mContext.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.ZA();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dnB != null) {
                                            a.this.dnB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dpy.a(a.this.dpz);
                            }
                            a.this.dpy.H(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.ZA();
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
            this.dnB = viewEventCenter;
        }
    }

    private void createView() {
        this.bdR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dpt = this.bdR.findViewById(e.g.rec_forum_list_container);
        this.dpu = (TextView) this.bdR.findViewById(e.g.view_skip);
        this.axd = (TextView) this.bdR.findViewById(e.g.view_recommend_tip);
        this.dpv = this.bdR.findViewById(e.g.view_top_divider);
        this.OF = (BdListView) this.bdR.findViewById(e.g.listview_forums);
        this.dpw = (TextView) this.bdR.findViewById(e.g.view_forums_concern);
        this.dpw.setClickable(true);
        this.dpx = new c(this.mContext.getPageActivity());
        this.OF.setAdapter((ListAdapter) this.dpx);
        this.OF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.d(a.this.forumList, i) != null) {
                    ((b) v.d(a.this.forumList, i)).isSelected = !((b) v.d(a.this.forumList, i)).isSelected;
                    a.this.dpx.setData(a.this.forumList);
                    a.this.dpx.notifyDataSetChanged();
                }
            }
        });
        this.dpu.setOnClickListener(this.mClickListener);
        this.dpw.setOnClickListener(this.mClickListener);
        this.bdR.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void bl(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.I(list)) {
                ZA();
                return;
            }
            if (this.bdR == null) {
                createView();
            }
            this.dpw.setClickable(true);
            this.isShowing = true;
            if (this.bdR.getParent() == null) {
                d.ad(this.mRootView).a(this.mRootView, this.bdR, false);
            }
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.mContext.getPageActivity(), e.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bdR.setVisibility(0);
                    a.this.dpt.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dpx.setData(this.forumList);
            this.dpx.notifyDataSetChanged();
            TiebaStatic.log(new am("c12238").aA("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void ZA() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bdR != null && this.mRootView != null) {
                this.bdR.setVisibility(8);
                if (this.bdR.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bdR);
                }
            }
        }
    }

    public void onDestroy() {
        ZA();
        if (this.dpy != null) {
            this.dpy.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        al.h(this.dpu, e.d.cp_cont_d);
        al.h(this.axd, e.d.cp_cont_d);
        al.j(this.dpv, e.d.cp_bg_line_c);
        al.h(this.dpw, e.d.common_color_10310);
        al.i(this.dpw, e.f.bule_bg_commen_label_button);
        al.i(this.bdR, e.d.black_alpha50);
        al.i(this.dpt, e.f.bg_recommend_forum_by_tag);
        this.dpx.notifyDataSetChanged();
    }

    public View avI() {
        return this.bdR;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
