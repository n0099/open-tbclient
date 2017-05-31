package com.baidu.tieba.frs.g;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.d.e;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends p<bl, c> implements e {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    private View a(int i, View view, bl blVar, c cVar) {
        String str;
        String str2;
        if (blVar == null || !(blVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d_1);
            aq.k(cVar.ckk, w.e.cp_bg_line_c_1);
            aq.i(cVar.ckn, w.e.cp_cont_e);
            aq.i(cVar.ckp, w.e.cp_cont_e);
            aq.i(cVar.ckm, w.e.cp_cont_b);
            aq.i(cVar.cko, w.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d);
            aq.k(cVar.ckk, w.e.cp_bg_line_c);
            aq.i(cVar.ckn, w.e.common_color_10139);
            aq.i(cVar.ckp, w.e.common_color_10139);
            aq.i(cVar.ckm, w.e.cp_bg_line_k);
            aq.i(cVar.cko, w.e.cp_bg_line_k);
            str = "#3385ff";
        }
        z zVar = (z) blVar;
        String str3 = zVar.Vg;
        if (!StringUtils.isNull(str3)) {
            cVar.ckl.setVisibility(0);
            cVar.bzC.setVisibility(8);
            cVar.ckl.setIsRound(true);
            cVar.ckl.setUserId(blVar.getAuthor().getUserId());
            cVar.ckl.setImageDrawable(null);
            cVar.ckl.c(str3, 10, false);
        }
        cVar.ckm.setText(zVar.userName);
        cVar.ckn.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        cVar.cko.setText(Html.fromHtml(str2));
        cVar.ckp.setText(zVar.Vh);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                cVar.ckv.setVisibility(0);
                cVar.ckq.setVisibility(8);
                cVar.ckr.setVisibility(8);
                cVar.cks.setVisibility(8);
                cVar.ckt.setVisibility(8);
                cVar.cku.setVisibility(8);
                cVar.ckv.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.ckv.setVisibility(8);
                cVar.ckq.setVisibility(8);
                cVar.ckr.setVisibility(8);
                cVar.cks.setVisibility(8);
                cVar.ckt.setVisibility(0);
                cVar.cku.setVisibility(8);
                cVar.ckF.c(zVar.pics.get(0), 10, false);
                cVar.ckG.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.ckv.setVisibility(8);
                cVar.ckq.setVisibility(0);
                cVar.ckr.setVisibility(8);
                cVar.cks.setVisibility(8);
                cVar.ckt.setVisibility(8);
                cVar.cku.setVisibility(8);
                cVar.ckw.c(zVar.pics.get(0), 10, false);
                cVar.ckx.c(zVar.pics.get(1), 10, false);
                cVar.cky.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.ckv.setVisibility(8);
                cVar.ckq.setVisibility(8);
                cVar.ckr.setVisibility(8);
                cVar.cks.setVisibility(8);
                cVar.ckt.setVisibility(0);
                cVar.cku.setVisibility(0);
                cVar.ckF.c(zVar.pics.get(0), 10, false);
                cVar.ckG.c(zVar.pics.get(1), 10, false);
                cVar.ckH.c(zVar.pics.get(2), 10, false);
                cVar.ckI.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.ckv.setVisibility(8);
                cVar.ckq.setVisibility(0);
                cVar.ckr.setVisibility(8);
                cVar.cks.setVisibility(8);
                cVar.ckt.setVisibility(0);
                cVar.cku.setVisibility(8);
                cVar.ckF.c(zVar.pics.get(0), 10, false);
                cVar.ckG.c(zVar.pics.get(1), 10, false);
                cVar.ckw.c(zVar.pics.get(2), 10, false);
                cVar.ckx.c(zVar.pics.get(3), 10, false);
                cVar.cky.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.ckv.setVisibility(8);
                cVar.ckq.setVisibility(0);
                cVar.ckr.setVisibility(0);
                cVar.cks.setVisibility(8);
                cVar.ckt.setVisibility(8);
                cVar.cku.setVisibility(8);
                cVar.ckw.c(zVar.pics.get(0), 10, false);
                cVar.ckx.c(zVar.pics.get(1), 10, false);
                cVar.cky.c(zVar.pics.get(2), 10, false);
                cVar.ckz.c(zVar.pics.get(3), 10, false);
                cVar.ckA.c(zVar.pics.get(4), 10, false);
                cVar.ckB.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.ckv.setVisibility(8);
                cVar.ckq.setVisibility(0);
                cVar.ckr.setVisibility(0);
                cVar.cks.setVisibility(0);
                cVar.ckt.setVisibility(8);
                cVar.cku.setVisibility(8);
                cVar.ckw.c(zVar.pics.get(0), 10, false);
                cVar.ckx.c(zVar.pics.get(1), 10, false);
                cVar.cky.c(zVar.pics.get(2), 10, false);
                cVar.ckz.c(zVar.pics.get(3), 10, false);
                cVar.ckA.c(zVar.pics.get(4), 10, false);
                cVar.ckB.c(zVar.pics.get(5), 10, false);
                cVar.ckC.c(zVar.pics.get(6), 10, false);
                cVar.ckD.c(zVar.pics.get(7), 10, false);
                cVar.ckE.c(zVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, zVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.ajh, LayoutInflater.from(this.mContext).inflate(w.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, blVar, cVar);
        return a(i, view, blVar, cVar);
    }
}
