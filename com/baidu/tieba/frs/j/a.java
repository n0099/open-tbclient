package com.baidu.tieba.frs.j;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.g.e;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends bf<bi, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bi biVar, c cVar) {
        String str;
        String str2;
        if (biVar == null || !(biVar instanceof w)) {
            return null;
        }
        if (this.mSkinType == 1) {
            av.l(cVar.mRootView, r.d.cp_bg_line_d_1);
            av.l(cVar.chY, r.d.cp_bg_line_c_1);
            av.j((View) cVar.cia, r.d.cp_cont_e);
            av.j((View) cVar.cic, r.d.cp_cont_e);
            av.j((View) cVar.bAa, r.d.cp_cont_b);
            av.j((View) cVar.cib, r.d.cp_cont_b);
            str = "#4f93ef";
        } else {
            av.l(cVar.mRootView, r.d.cp_bg_line_d);
            av.l(cVar.chY, r.d.cp_bg_line_c);
            av.j((View) cVar.cia, r.d.common_color_10139);
            av.j((View) cVar.cic, r.d.common_color_10139);
            av.j((View) cVar.bAa, r.d.cp_bg_line_k);
            av.j((View) cVar.cib, r.d.cp_bg_line_k);
            str = "#3385ff";
        }
        w wVar = (w) biVar;
        String str3 = wVar.QT;
        if (!StringUtils.isNull(str3)) {
            cVar.chZ.setVisibility(0);
            cVar.bXk.setVisibility(8);
            cVar.chZ.setIsRound(true);
            cVar.chZ.setUserId(biVar.getAuthor().getUserId());
            cVar.chZ.setImageDrawable(null);
            cVar.chZ.c(str3, 10, false);
        }
        cVar.bAa.setText(wVar.userName);
        cVar.cia.setText(wVar.tips);
        if (StringUtils.isNull(wVar.type)) {
            str2 = wVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + wVar.type + "·</font>" + wVar.title;
        }
        cVar.cib.setText(Html.fromHtml(str2));
        cVar.cic.setText(wVar.QU);
        if (wVar.pics != null) {
            int size = wVar.pics.size();
            if (size == 1) {
                cVar.cij.setVisibility(0);
                cVar.cie.setVisibility(8);
                cVar.cif.setVisibility(8);
                cVar.cig.setVisibility(8);
                cVar.cih.setVisibility(8);
                cVar.cii.setVisibility(8);
                cVar.cij.c(wVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.cij.setVisibility(8);
                cVar.cie.setVisibility(8);
                cVar.cif.setVisibility(8);
                cVar.cig.setVisibility(8);
                cVar.cih.setVisibility(0);
                cVar.cii.setVisibility(8);
                cVar.cit.c(wVar.pics.get(0), 10, false);
                cVar.ciu.c(wVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.cij.setVisibility(8);
                cVar.cie.setVisibility(0);
                cVar.cif.setVisibility(8);
                cVar.cig.setVisibility(8);
                cVar.cih.setVisibility(8);
                cVar.cii.setVisibility(8);
                cVar.cik.c(wVar.pics.get(0), 10, false);
                cVar.cil.c(wVar.pics.get(1), 10, false);
                cVar.cim.c(wVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.cij.setVisibility(8);
                cVar.cie.setVisibility(8);
                cVar.cif.setVisibility(8);
                cVar.cig.setVisibility(8);
                cVar.cih.setVisibility(0);
                cVar.cii.setVisibility(0);
                cVar.cit.c(wVar.pics.get(0), 10, false);
                cVar.ciu.c(wVar.pics.get(1), 10, false);
                cVar.civ.c(wVar.pics.get(2), 10, false);
                cVar.ciw.c(wVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.cij.setVisibility(8);
                cVar.cie.setVisibility(0);
                cVar.cif.setVisibility(8);
                cVar.cig.setVisibility(8);
                cVar.cih.setVisibility(0);
                cVar.cii.setVisibility(8);
                cVar.cit.c(wVar.pics.get(0), 10, false);
                cVar.ciu.c(wVar.pics.get(1), 10, false);
                cVar.cik.c(wVar.pics.get(2), 10, false);
                cVar.cil.c(wVar.pics.get(3), 10, false);
                cVar.cim.c(wVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.cij.setVisibility(8);
                cVar.cie.setVisibility(0);
                cVar.cif.setVisibility(0);
                cVar.cig.setVisibility(8);
                cVar.cih.setVisibility(8);
                cVar.cii.setVisibility(8);
                cVar.cik.c(wVar.pics.get(0), 10, false);
                cVar.cil.c(wVar.pics.get(1), 10, false);
                cVar.cim.c(wVar.pics.get(2), 10, false);
                cVar.cin.c(wVar.pics.get(3), 10, false);
                cVar.cio.c(wVar.pics.get(4), 10, false);
                cVar.cip.c(wVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.cij.setVisibility(8);
                cVar.cie.setVisibility(0);
                cVar.cif.setVisibility(0);
                cVar.cig.setVisibility(0);
                cVar.cih.setVisibility(8);
                cVar.cii.setVisibility(8);
                cVar.cik.c(wVar.pics.get(0), 10, false);
                cVar.cil.c(wVar.pics.get(1), 10, false);
                cVar.cim.c(wVar.pics.get(2), 10, false);
                cVar.cin.c(wVar.pics.get(3), 10, false);
                cVar.cio.c(wVar.pics.get(4), 10, false);
                cVar.cip.c(wVar.pics.get(5), 10, false);
                cVar.ciq.c(wVar.pics.get(6), 10, false);
                cVar.cir.c(wVar.pics.get(7), 10, false);
                cVar.cis.c(wVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, wVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public c a(ViewGroup viewGroup) {
        return new c(this.aRd, LayoutInflater.from(this.mContext).inflate(r.h.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bf, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) biVar, (bi) cVar);
        return a(i, view, biVar, cVar);
    }
}
