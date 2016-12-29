package com.baidu.tieba.frs.i;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.g.e;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends au<bg, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bg bgVar, c cVar) {
        String str;
        String str2;
        if (bgVar == null || !(bgVar instanceof x)) {
            return null;
        }
        if (this.mSkinType == 1) {
            ar.l(cVar.mRootView, r.d.cp_bg_line_d_1);
            ar.l(cVar.bSq, r.d.cp_bg_line_c_1);
            ar.j((View) cVar.bSt, r.d.cp_cont_e);
            ar.j((View) cVar.bSv, r.d.cp_cont_e);
            ar.j((View) cVar.bSs, r.d.cp_cont_b);
            ar.j((View) cVar.bSu, r.d.cp_cont_b);
            str = "#4f93ef";
        } else {
            ar.l(cVar.mRootView, r.d.cp_bg_line_d);
            ar.l(cVar.bSq, r.d.cp_bg_line_c);
            ar.j((View) cVar.bSt, r.d.common_color_10139);
            ar.j((View) cVar.bSv, r.d.common_color_10139);
            ar.j((View) cVar.bSs, r.d.cp_bg_line_k);
            ar.j((View) cVar.bSu, r.d.cp_bg_line_k);
            str = "#3385ff";
        }
        x xVar = (x) bgVar;
        String str3 = xVar.Rl;
        if (!StringUtils.isNull(str3)) {
            cVar.bSr.setVisibility(0);
            cVar.bGj.setVisibility(8);
            cVar.bSr.setIsRound(true);
            cVar.bSr.setUserId(bgVar.getAuthor().getUserId());
            cVar.bSr.setImageDrawable(null);
            cVar.bSr.c(str3, 10, false);
        }
        cVar.bSs.setText(xVar.userName);
        cVar.bSt.setText(xVar.tips);
        if (StringUtils.isNull(xVar.type)) {
            str2 = xVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + xVar.type + "·</font>" + xVar.title;
        }
        cVar.bSu.setText(Html.fromHtml(str2));
        cVar.bSv.setText(xVar.Rm);
        if (xVar.pics != null) {
            int size = xVar.pics.size();
            if (size == 1) {
                cVar.bSB.setVisibility(0);
                cVar.bSw.setVisibility(8);
                cVar.bSx.setVisibility(8);
                cVar.bSy.setVisibility(8);
                cVar.bSz.setVisibility(8);
                cVar.bSA.setVisibility(8);
                cVar.bSB.c(xVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.bSB.setVisibility(8);
                cVar.bSw.setVisibility(8);
                cVar.bSx.setVisibility(8);
                cVar.bSy.setVisibility(8);
                cVar.bSz.setVisibility(0);
                cVar.bSA.setVisibility(8);
                cVar.bSL.c(xVar.pics.get(0), 10, false);
                cVar.bSM.c(xVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.bSB.setVisibility(8);
                cVar.bSw.setVisibility(0);
                cVar.bSx.setVisibility(8);
                cVar.bSy.setVisibility(8);
                cVar.bSz.setVisibility(8);
                cVar.bSA.setVisibility(8);
                cVar.bSC.c(xVar.pics.get(0), 10, false);
                cVar.bSD.c(xVar.pics.get(1), 10, false);
                cVar.bSE.c(xVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.bSB.setVisibility(8);
                cVar.bSw.setVisibility(8);
                cVar.bSx.setVisibility(8);
                cVar.bSy.setVisibility(8);
                cVar.bSz.setVisibility(0);
                cVar.bSA.setVisibility(0);
                cVar.bSL.c(xVar.pics.get(0), 10, false);
                cVar.bSM.c(xVar.pics.get(1), 10, false);
                cVar.bSN.c(xVar.pics.get(2), 10, false);
                cVar.bSO.c(xVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.bSB.setVisibility(8);
                cVar.bSw.setVisibility(0);
                cVar.bSx.setVisibility(8);
                cVar.bSy.setVisibility(8);
                cVar.bSz.setVisibility(0);
                cVar.bSA.setVisibility(8);
                cVar.bSL.c(xVar.pics.get(0), 10, false);
                cVar.bSM.c(xVar.pics.get(1), 10, false);
                cVar.bSC.c(xVar.pics.get(2), 10, false);
                cVar.bSD.c(xVar.pics.get(3), 10, false);
                cVar.bSE.c(xVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.bSB.setVisibility(8);
                cVar.bSw.setVisibility(0);
                cVar.bSx.setVisibility(0);
                cVar.bSy.setVisibility(8);
                cVar.bSz.setVisibility(8);
                cVar.bSA.setVisibility(8);
                cVar.bSC.c(xVar.pics.get(0), 10, false);
                cVar.bSD.c(xVar.pics.get(1), 10, false);
                cVar.bSE.c(xVar.pics.get(2), 10, false);
                cVar.bSF.c(xVar.pics.get(3), 10, false);
                cVar.bSG.c(xVar.pics.get(4), 10, false);
                cVar.bSH.c(xVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.bSB.setVisibility(8);
                cVar.bSw.setVisibility(0);
                cVar.bSx.setVisibility(0);
                cVar.bSy.setVisibility(0);
                cVar.bSz.setVisibility(8);
                cVar.bSA.setVisibility(8);
                cVar.bSC.c(xVar.pics.get(0), 10, false);
                cVar.bSD.c(xVar.pics.get(1), 10, false);
                cVar.bSE.c(xVar.pics.get(2), 10, false);
                cVar.bSF.c(xVar.pics.get(3), 10, false);
                cVar.bSG.c(xVar.pics.get(4), 10, false);
                cVar.bSH.c(xVar.pics.get(5), 10, false);
                cVar.bSI.c(xVar.pics.get(6), 10, false);
                cVar.bSJ.c(xVar.pics.get(7), 10, false);
                cVar.bSK.c(xVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, xVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: P */
    public c a(ViewGroup viewGroup) {
        return new c(this.aSs, LayoutInflater.from(this.mContext).inflate(r.h.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.au, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bg bgVar, c cVar) {
        super.a(i, view, viewGroup, (ViewGroup) bgVar, (bg) cVar);
        return a(i, view, bgVar, cVar);
    }
}
