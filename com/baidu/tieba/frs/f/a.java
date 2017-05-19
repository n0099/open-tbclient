package com.baidu.tieba.frs.f;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.c.e;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends p<bk, c> implements e {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    private View a(int i, View view, bk bkVar, c cVar) {
        String str;
        String str2;
        if (bkVar == null || !(bkVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d_1);
            aq.k(cVar.cdW, w.e.cp_bg_line_c_1);
            aq.i(cVar.cdZ, w.e.cp_cont_e);
            aq.i(cVar.ceb, w.e.cp_cont_e);
            aq.i(cVar.cdY, w.e.cp_cont_b);
            aq.i(cVar.cea, w.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d);
            aq.k(cVar.cdW, w.e.cp_bg_line_c);
            aq.i(cVar.cdZ, w.e.common_color_10139);
            aq.i(cVar.ceb, w.e.common_color_10139);
            aq.i(cVar.cdY, w.e.cp_bg_line_k);
            aq.i(cVar.cea, w.e.cp_bg_line_k);
            str = "#3385ff";
        }
        z zVar = (z) bkVar;
        String str3 = zVar.Vt;
        if (!StringUtils.isNull(str3)) {
            cVar.cdX.setVisibility(0);
            cVar.buV.setVisibility(8);
            cVar.cdX.setIsRound(true);
            cVar.cdX.setUserId(bkVar.getAuthor().getUserId());
            cVar.cdX.setImageDrawable(null);
            cVar.cdX.c(str3, 10, false);
        }
        cVar.cdY.setText(zVar.userName);
        cVar.cdZ.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        cVar.cea.setText(Html.fromHtml(str2));
        cVar.ceb.setText(zVar.Vu);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                cVar.ceh.setVisibility(0);
                cVar.cec.setVisibility(8);
                cVar.ced.setVisibility(8);
                cVar.cee.setVisibility(8);
                cVar.cef.setVisibility(8);
                cVar.ceg.setVisibility(8);
                cVar.ceh.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.ceh.setVisibility(8);
                cVar.cec.setVisibility(8);
                cVar.ced.setVisibility(8);
                cVar.cee.setVisibility(8);
                cVar.cef.setVisibility(0);
                cVar.ceg.setVisibility(8);
                cVar.cer.c(zVar.pics.get(0), 10, false);
                cVar.ces.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.ceh.setVisibility(8);
                cVar.cec.setVisibility(0);
                cVar.ced.setVisibility(8);
                cVar.cee.setVisibility(8);
                cVar.cef.setVisibility(8);
                cVar.ceg.setVisibility(8);
                cVar.cei.c(zVar.pics.get(0), 10, false);
                cVar.cej.c(zVar.pics.get(1), 10, false);
                cVar.cek.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.ceh.setVisibility(8);
                cVar.cec.setVisibility(8);
                cVar.ced.setVisibility(8);
                cVar.cee.setVisibility(8);
                cVar.cef.setVisibility(0);
                cVar.ceg.setVisibility(0);
                cVar.cer.c(zVar.pics.get(0), 10, false);
                cVar.ces.c(zVar.pics.get(1), 10, false);
                cVar.cet.c(zVar.pics.get(2), 10, false);
                cVar.ceu.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.ceh.setVisibility(8);
                cVar.cec.setVisibility(0);
                cVar.ced.setVisibility(8);
                cVar.cee.setVisibility(8);
                cVar.cef.setVisibility(0);
                cVar.ceg.setVisibility(8);
                cVar.cer.c(zVar.pics.get(0), 10, false);
                cVar.ces.c(zVar.pics.get(1), 10, false);
                cVar.cei.c(zVar.pics.get(2), 10, false);
                cVar.cej.c(zVar.pics.get(3), 10, false);
                cVar.cek.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.ceh.setVisibility(8);
                cVar.cec.setVisibility(0);
                cVar.ced.setVisibility(0);
                cVar.cee.setVisibility(8);
                cVar.cef.setVisibility(8);
                cVar.ceg.setVisibility(8);
                cVar.cei.c(zVar.pics.get(0), 10, false);
                cVar.cej.c(zVar.pics.get(1), 10, false);
                cVar.cek.c(zVar.pics.get(2), 10, false);
                cVar.cel.c(zVar.pics.get(3), 10, false);
                cVar.cem.c(zVar.pics.get(4), 10, false);
                cVar.cen.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.ceh.setVisibility(8);
                cVar.cec.setVisibility(0);
                cVar.ced.setVisibility(0);
                cVar.cee.setVisibility(0);
                cVar.cef.setVisibility(8);
                cVar.ceg.setVisibility(8);
                cVar.cei.c(zVar.pics.get(0), 10, false);
                cVar.cej.c(zVar.pics.get(1), 10, false);
                cVar.cek.c(zVar.pics.get(2), 10, false);
                cVar.cel.c(zVar.pics.get(3), 10, false);
                cVar.cem.c(zVar.pics.get(4), 10, false);
                cVar.cen.c(zVar.pics.get(5), 10, false);
                cVar.ceo.c(zVar.pics.get(6), 10, false);
                cVar.cep.c(zVar.pics.get(7), 10, false);
                cVar.ceq.c(zVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, zVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: R */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.ajr, LayoutInflater.from(this.mContext).inflate(w.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.p, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bk bkVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, bkVar, cVar);
        return a(i, view, bkVar, cVar);
    }
}
