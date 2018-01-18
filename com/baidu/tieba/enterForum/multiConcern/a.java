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
    private TextView aQH;
    private TbPageContext<?> aQp;
    private BdListView avj;
    private View bvP;
    private ViewEventCenter dlJ;
    private View dne;
    private TextView dnf;
    private View dng;
    private TextView dnh;
    private c dni;
    private MultiConcernModel dnj;
    private MultiConcernModel.a dnk;
    private List<b> forumList;
    private boolean isShowing = false;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != a.this.bvP) {
                if (view != a.this.dnf) {
                    if (view == a.this.dnh) {
                        ArrayList<Long> arrayList = new ArrayList<>();
                        StringBuilder sb = new StringBuilder();
                        for (b bVar : a.this.forumList) {
                            if (bVar.isSelected) {
                                arrayList.add(Long.valueOf(bVar.forumId));
                                sb.append(bVar.forumId);
                            }
                        }
                        TiebaStatic.log(new ak("c12239").ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_ID, sb.toString()));
                        if (v.E(arrayList)) {
                            a.this.Vq();
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                            return;
                        } else if (!l.oZ()) {
                            l.showToast(a.this.aQp.getPageActivity(), d.j.neterror);
                            return;
                        } else {
                            a.this.dnh.setClickable(false);
                            if (a.this.dnj == null) {
                                a.this.dnj = new MultiConcernModel(a.this.aQp);
                            }
                            if (a.this.dnk == null) {
                                a.this.dnk = new MultiConcernModel.a() { // from class: com.baidu.tieba.enterForum.multiConcern.a.1.1
                                    @Override // com.baidu.tieba.enterForum.multiConcern.MultiConcernModel.a
                                    public void C(int i, String str) {
                                        a.this.dnh.setClickable(true);
                                        if (i != 0) {
                                            l.showToast(a.this.aQp.getPageActivity(), str);
                                            return;
                                        }
                                        a.this.Vq();
                                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                                        if (a.this.dlJ != null) {
                                            a.this.dlJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
                                        }
                                    }
                                };
                                a.this.dnj.a(a.this.dnk);
                            }
                            a.this.dnj.E(arrayList);
                            return;
                        }
                    }
                    return;
                }
                a.this.Vq();
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_recommend_forums_window_", false);
                TiebaStatic.log(new ak("c12240").ab("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    };
    private ViewGroup mRootView;

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aQp = tbPageContext;
            this.mRootView = viewGroup;
            this.dlJ = viewEventCenter;
        }
    }

    private void createView() {
        this.bvP = LayoutInflater.from(this.aQp.getPageActivity()).inflate(d.h.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.dne = this.bvP.findViewById(d.g.rec_forum_list_container);
        this.dnf = (TextView) this.bvP.findViewById(d.g.view_skip);
        this.aQH = (TextView) this.bvP.findViewById(d.g.view_recommend_tip);
        this.dng = this.bvP.findViewById(d.g.view_top_divider);
        this.avj = (BdListView) this.bvP.findViewById(d.g.listview_forums);
        this.dnh = (TextView) this.bvP.findViewById(d.g.view_forums_concern);
        this.dnh.setClickable(true);
        this.dni = new c(this.aQp.getPageActivity());
        this.avj.setAdapter((ListAdapter) this.dni);
        this.avj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.enterForum.multiConcern.a.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (v.f(a.this.forumList, i) != null) {
                    ((b) v.f(a.this.forumList, i)).isSelected = !((b) v.f(a.this.forumList, i)).isSelected;
                    a.this.dni.setData(a.this.forumList);
                    a.this.dni.notifyDataSetChanged();
                }
            }
        });
        this.dnf.setOnClickListener(this.mClickListener);
        this.dnh.setOnClickListener(this.mClickListener);
        this.bvP.setOnClickListener(this.mClickListener);
        onChangeSkinType();
    }

    public void aR(List<b> list) {
        this.forumList = list;
        if (!this.isShowing && this.mRootView != null) {
            if (v.E(list)) {
                Vq();
                return;
            }
            if (this.bvP == null) {
                createView();
            }
            this.dnh.setClickable(true);
            this.isShowing = true;
            if (this.bvP.getParent() == null) {
                com.baidu.tbadk.j.d.bl(this.mRootView).a(this.mRootView, this.bvP, false);
            }
            e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.multiConcern.a.3
                @Override // java.lang.Runnable
                public void run() {
                    Animation loadAnimation = AnimationUtils.loadAnimation(a.this.aQp.getPageActivity(), d.a.anim_recommend_forums_window);
                    loadAnimation.setFillAfter(true);
                    a.this.bvP.setVisibility(0);
                    a.this.dne.startAnimation(loadAnimation);
                }
            }, 100L);
            this.dni.setData(this.forumList);
            this.dni.notifyDataSetChanged();
            TiebaStatic.log(new ak("c12238").ab("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public void Vq() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bvP != null && this.mRootView != null) {
                this.bvP.setVisibility(8);
                if (this.bvP.getParent() == this.mRootView) {
                    this.mRootView.removeView(this.bvP);
                }
            }
        }
    }

    public void onDestroy() {
        Vq();
        if (this.dnj != null) {
            this.dnj.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        aj.r(this.dnf, d.C0107d.cp_cont_d);
        aj.r(this.aQH, d.C0107d.cp_cont_d);
        aj.t(this.dng, d.C0107d.cp_bg_line_c);
        aj.r(this.dnh, d.C0107d.common_color_10310);
        aj.s(this.dnh, d.f.bule_bg_commen_label_button);
        aj.s(this.bvP, d.C0107d.black_alpha50);
        aj.s(this.dne, d.f.bg_recommend_forum_by_tag);
        this.dni.notifyDataSetChanged();
    }

    public View aqe() {
        return this.bvP;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
