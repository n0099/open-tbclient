package com.baidu.tieba.frs.h;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.e.e;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends av<bi, c> implements e {
    public a(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    private View a(int i, View view, bi biVar, c cVar) {
        String str;
        String str2;
        if (biVar == null || !(biVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d_1);
            aq.k(cVar.ceJ, w.e.cp_bg_line_c_1);
            aq.i(cVar.ceM, w.e.cp_cont_e);
            aq.i(cVar.ceO, w.e.cp_cont_e);
            aq.i(cVar.ceL, w.e.cp_cont_b);
            aq.i(cVar.ceN, w.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aq.k(cVar.mRootView, w.e.cp_bg_line_d);
            aq.k(cVar.ceJ, w.e.cp_bg_line_c);
            aq.i(cVar.ceM, w.e.common_color_10139);
            aq.i(cVar.ceO, w.e.common_color_10139);
            aq.i(cVar.ceL, w.e.cp_bg_line_k);
            aq.i(cVar.ceN, w.e.cp_bg_line_k);
            str = "#3385ff";
        }
        z zVar = (z) biVar;
        String str3 = zVar.VY;
        if (!StringUtils.isNull(str3)) {
            cVar.ceK.setVisibility(0);
            cVar.bTu.setVisibility(8);
            cVar.ceK.setIsRound(true);
            cVar.ceK.setUserId(biVar.getAuthor().getUserId());
            cVar.ceK.setImageDrawable(null);
            cVar.ceK.c(str3, 10, false);
        }
        cVar.ceL.setText(zVar.userName);
        cVar.ceM.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        cVar.ceN.setText(Html.fromHtml(str2));
        cVar.ceO.setText(zVar.VZ);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                cVar.ceU.setVisibility(0);
                cVar.ceP.setVisibility(8);
                cVar.ceQ.setVisibility(8);
                cVar.ceR.setVisibility(8);
                cVar.ceS.setVisibility(8);
                cVar.ceT.setVisibility(8);
                cVar.ceU.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                cVar.ceU.setVisibility(8);
                cVar.ceP.setVisibility(8);
                cVar.ceQ.setVisibility(8);
                cVar.ceR.setVisibility(8);
                cVar.ceS.setVisibility(0);
                cVar.ceT.setVisibility(8);
                cVar.cfe.c(zVar.pics.get(0), 10, false);
                cVar.cff.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                cVar.ceU.setVisibility(8);
                cVar.ceP.setVisibility(0);
                cVar.ceQ.setVisibility(8);
                cVar.ceR.setVisibility(8);
                cVar.ceS.setVisibility(8);
                cVar.ceT.setVisibility(8);
                cVar.ceV.c(zVar.pics.get(0), 10, false);
                cVar.ceW.c(zVar.pics.get(1), 10, false);
                cVar.ceX.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                cVar.ceU.setVisibility(8);
                cVar.ceP.setVisibility(8);
                cVar.ceQ.setVisibility(8);
                cVar.ceR.setVisibility(8);
                cVar.ceS.setVisibility(0);
                cVar.ceT.setVisibility(0);
                cVar.cfe.c(zVar.pics.get(0), 10, false);
                cVar.cff.c(zVar.pics.get(1), 10, false);
                cVar.cfg.c(zVar.pics.get(2), 10, false);
                cVar.cfh.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                cVar.ceU.setVisibility(8);
                cVar.ceP.setVisibility(0);
                cVar.ceQ.setVisibility(8);
                cVar.ceR.setVisibility(8);
                cVar.ceS.setVisibility(0);
                cVar.ceT.setVisibility(8);
                cVar.cfe.c(zVar.pics.get(0), 10, false);
                cVar.cff.c(zVar.pics.get(1), 10, false);
                cVar.ceV.c(zVar.pics.get(2), 10, false);
                cVar.ceW.c(zVar.pics.get(3), 10, false);
                cVar.ceX.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                cVar.ceU.setVisibility(8);
                cVar.ceP.setVisibility(0);
                cVar.ceQ.setVisibility(0);
                cVar.ceR.setVisibility(8);
                cVar.ceS.setVisibility(8);
                cVar.ceT.setVisibility(8);
                cVar.ceV.c(zVar.pics.get(0), 10, false);
                cVar.ceW.c(zVar.pics.get(1), 10, false);
                cVar.ceX.c(zVar.pics.get(2), 10, false);
                cVar.ceY.c(zVar.pics.get(3), 10, false);
                cVar.ceZ.c(zVar.pics.get(4), 10, false);
                cVar.cfa.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                cVar.ceU.setVisibility(8);
                cVar.ceP.setVisibility(0);
                cVar.ceQ.setVisibility(0);
                cVar.ceR.setVisibility(0);
                cVar.ceS.setVisibility(8);
                cVar.ceT.setVisibility(8);
                cVar.ceV.c(zVar.pics.get(0), 10, false);
                cVar.ceW.c(zVar.pics.get(1), 10, false);
                cVar.ceX.c(zVar.pics.get(2), 10, false);
                cVar.ceY.c(zVar.pics.get(3), 10, false);
                cVar.ceZ.c(zVar.pics.get(4), 10, false);
                cVar.cfa.c(zVar.pics.get(5), 10, false);
                cVar.cfb.c(zVar.pics.get(6), 10, false);
                cVar.cfc.c(zVar.pics.get(7), 10, false);
                cVar.cfd.c(zVar.pics.get(8), 10, false);
            }
        }
        cVar.mRootView.setOnClickListener(new b(this, zVar));
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public c onCreateViewHolder(ViewGroup viewGroup) {
        return new c(this.bcy, LayoutInflater.from(this.mContext).inflate(w.j.frs_wefan_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bi biVar, c cVar) {
        super.onFillViewHolder(i, view, viewGroup, biVar, cVar);
        return a(i, view, biVar, cVar);
    }
}
