package com.baidu.tieba.frs.g;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.d.e;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends p<bm, c> implements e {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    private View a(int i, View view, bm bmVar, c cVar) {
        String str;
        String str2;
        if (bmVar == null || !(bmVar instanceof aa)) {
            return null;
        }
        if (this.mSkinType == 1) {
            as.k(cVar.mRootView, w.e.cp_bg_line_d_1);
            as.k(cVar.csb, w.e.cp_bg_line_c_1);
            as.i(cVar.cse, w.e.cp_cont_e);
            as.i(cVar.csg, w.e.cp_cont_e);
            as.i(cVar.csd, w.e.cp_cont_b);
            as.i(cVar.csf, w.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            as.k(cVar.mRootView, w.e.cp_bg_line_d);
            as.k(cVar.csb, w.e.cp_bg_line_c);
            as.i(cVar.cse, w.e.common_color_10139);
            as.i(cVar.csg, w.e.common_color_10139);
            as.i(cVar.csd, w.e.cp_bg_line_k);
            as.i(cVar.csf, w.e.cp_bg_line_k);
            str = "#3385ff";
        }
        aa aaVar = (aa) bmVar;
        String str3 = aaVar.Vg;
        if (!StringUtils.isNull(str3)) {
            cVar.csc.setVisibility(0);
            cVar.bAv.setVisibility(8);
            cVar.csc.setIsRound(true);
            cVar.csc.setUserId(bmVar.getAuthor().getUserId());
            cVar.csc.setImageDrawable(null);
            cVar.csc.c(str3, 10, false);
        }
        cVar.csd.setText(aaVar.userName);
        cVar.cse.setText(aaVar.tips);
        if (StringUtils.isNull(aaVar.type)) {
            str2 = aaVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + aaVar.type + "·</font>" + aaVar.title;
        }
        cVar.csf.setText(Html.fromHtml(str2));
        cVar.csg.setText(aaVar.Vh);
        if (aaVar.pics != null) {
            int size = aaVar.pics.size();
            if (size == 1) {
                cVar.csm.setVisibility(0);
                cVar.csh.setVisibility(8);
                cVar.csi.setVisibility(8);
                cVar.csj.setVisibility(8);
                cVar.csk.setVisibility(8);
                cVar.csl.setVisibility(8);
                cVar.csm.c(aaVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.csm.setVisibility(8);
                cVar.csh.setVisibility(8);
                cVar.csi.setVisibility(8);
                cVar.csj.setVisibility(8);
                cVar.csk.setVisibility(0);
                cVar.csl.setVisibility(8);
                cVar.csw.c(aaVar.pics.get(0), 10, false);
                cVar.csx.c(aaVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.csm.setVisibility(8);
                cVar.csh.setVisibility(0);
                cVar.csi.setVisibility(8);
                cVar.csj.setVisibility(8);
                cVar.csk.setVisibility(8);
                cVar.csl.setVisibility(8);
                cVar.csn.c(aaVar.pics.get(0), 10, false);
                cVar.cso.c(aaVar.pics.get(1), 10, false);
                cVar.csp.c(aaVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.csm.setVisibility(8);
                cVar.csh.setVisibility(8);
                cVar.csi.setVisibility(8);
                cVar.csj.setVisibility(8);
                cVar.csk.setVisibility(0);
                cVar.csl.setVisibility(0);
                cVar.csw.c(aaVar.pics.get(0), 10, false);
                cVar.csx.c(aaVar.pics.get(1), 10, false);
                cVar.csy.c(aaVar.pics.get(2), 10, false);
                cVar.csz.c(aaVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.csm.setVisibility(8);
                cVar.csh.setVisibility(0);
                cVar.csi.setVisibility(8);
                cVar.csj.setVisibility(8);
                cVar.csk.setVisibility(0);
                cVar.csl.setVisibility(8);
                cVar.csw.c(aaVar.pics.get(0), 10, false);
                cVar.csx.c(aaVar.pics.get(1), 10, false);
                cVar.csn.c(aaVar.pics.get(2), 10, false);
                cVar.cso.c(aaVar.pics.get(3), 10, false);
                cVar.csp.c(aaVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.csm.setVisibility(8);
                cVar.csh.setVisibility(0);
                cVar.csi.setVisibility(0);
                cVar.csj.setVisibility(8);
                cVar.csk.setVisibility(8);
                cVar.csl.setVisibility(8);
                cVar.csn.c(aaVar.pics.get(0), 10, false);
                cVar.cso.c(aaVar.pics.get(1), 10, false);
                cVar.csp.c(aaVar.pics.get(2), 10, false);
                cVar.csq.c(aaVar.pics.get(3), 10, false);
                cVar.csr.c(aaVar.pics.get(4), 10, false);
                cVar.css.c(aaVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.csm.setVisibility(8);
                cVar.csh.setVisibility(0);
                cVar.csi.setVisibility(0);
                cVar.csj.setVisibility(0);
                cVar.csk.setVisibility(8);
                cVar.csl.setVisibility(8);
                cVar.csn.c(aaVar.pics.get(0), 10, false);
                cVar.cso.c(aaVar.pics.get(1), 10, false);
                cVar.csp.c(aaVar.pics.get(2), 10, false);
                cVar.csq.c(aaVar.pics.get(3), 10, false);
                cVar.csr.c(aaVar.pics.get(4), 10, false);
                cVar.css.c(aaVar.pics.get(5), 10, false);
                cVar.cst.c(aaVar.pics.get(6), 10, false);
                cVar.csu.c(aaVar.pics.get(7), 10, false);
                cVar.csv.c(aaVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, aaVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.ajP, LayoutInflater.from(this.mContext).inflate(w.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bm bmVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bmVar, cVar);
        return a(i, view, bmVar, cVar);
    }
}
