package com.baidu.tieba.enterForum.multiConcern;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.multiConcern.MultiConcernModel;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdListView Ib;
    private ViewGroup ZO;
    private TextView aaK;
    private TbPageContext<?> aat;
    private ViewEventCenter bSq;
    private View bTQ;
    private View bTR;
    private TextView bTS;
    private View bTT;
    private TextView bTU;
    private h bTV;
    private MultiConcernModel bTW;
    private MultiConcernModel.a bTX;
    private List<g> forumList;
    private boolean isShowing = false;
    private View.OnClickListener bkk = new c(this);

    public b(TbPageContext<?> tbPageContext, ViewGroup viewGroup, ViewEventCenter viewEventCenter) {
        if (tbPageContext != null && viewGroup != null) {
            this.aat = tbPageContext;
            this.ZO = viewGroup;
            this.bSq = viewEventCenter;
        }
    }

    private void abg() {
        this.bTQ = LayoutInflater.from(this.aat.getPageActivity()).inflate(w.j.layout_recommend_forums_by_tag, (ViewGroup) null);
        this.bTR = this.bTQ.findViewById(w.h.rec_forum_list_container);
        this.bTS = (TextView) this.bTQ.findViewById(w.h.view_skip);
        this.aaK = (TextView) this.bTQ.findViewById(w.h.view_recommend_tip);
        this.bTT = this.bTQ.findViewById(w.h.view_top_divider);
        this.Ib = (BdListView) this.bTQ.findViewById(w.h.listview_forums);
        this.bTU = (TextView) this.bTQ.findViewById(w.h.view_forums_concern);
        this.bTU.setClickable(true);
        this.bTV = new h(this.aat.getPageActivity());
        this.Ib.setAdapter((ListAdapter) this.bTV);
        this.Ib.setOnItemClickListener(new e(this));
        this.bTS.setOnClickListener(this.bkk);
        this.bTU.setOnClickListener(this.bkk);
        this.bTQ.setOnClickListener(this.bkk);
        onChangeSkinType();
    }

    public void ao(List<g> list) {
        this.forumList = list;
        if (!this.isShowing && this.ZO != null) {
            if (z.t(list)) {
                abk();
                return;
            }
            if (this.bTQ == null) {
                abg();
            }
            this.bTU.setClickable(true);
            this.isShowing = true;
            if (this.bTQ.getParent() == null) {
                com.baidu.tbadk.i.d.K(this.ZO).a(this.ZO, this.bTQ, false);
            }
            com.baidu.adp.lib.g.h.fR().postDelayed(new f(this), 100L);
            this.bTV.setData(this.forumList);
            this.bTV.notifyDataSetChanged();
        }
    }

    public void abk() {
        if (this.isShowing) {
            this.isShowing = false;
            if (this.bTQ != null && this.ZO != null) {
                this.bTQ.setVisibility(8);
                if (this.bTQ.getParent() == this.ZO) {
                    this.ZO.removeView(this.bTQ);
                }
            }
        }
    }

    public void onDestroy() {
        abk();
        if (this.bTW != null) {
            this.bTW.cancelMessage();
        }
    }

    public void onChangeSkinType() {
        as.i(this.bTS, w.e.cp_cont_d);
        as.i(this.aaK, w.e.cp_cont_d);
        as.k(this.bTT, w.e.cp_bg_line_c);
        as.i(this.bTU, w.e.common_color_10310);
        as.j(this.bTU, w.g.bule_bg_commen_label_button);
        as.j(this.bTQ, w.e.black_alpha50);
        as.j(this.bTR, w.g.bg_recommend_forum_by_tag);
        this.bTV.notifyDataSetChanged();
    }

    public View abl() {
        return this.bTQ;
    }

    public boolean isShowing() {
        return this.isShowing;
    }
}
