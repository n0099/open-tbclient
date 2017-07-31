package com.baidu.tieba.frs.h;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d;
import com.baidu.tieba.frs.e.c;
/* loaded from: classes.dex */
public class a extends d<bl, b> implements c {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    private View a(int i, View view, bl blVar, b bVar) {
        String str;
        String str2;
        if (blVar == null || !(blVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            ai.k(bVar.mRootView, d.e.cp_bg_line_d_1);
            ai.k(bVar.cAG, d.e.cp_bg_line_c_1);
            ai.i(bVar.cAJ, d.e.cp_cont_e);
            ai.i(bVar.cAL, d.e.cp_cont_e);
            ai.i(bVar.cAI, d.e.cp_cont_b);
            ai.i(bVar.cAK, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            ai.k(bVar.mRootView, d.e.cp_bg_line_d);
            ai.k(bVar.cAG, d.e.cp_bg_line_c);
            ai.i(bVar.cAJ, d.e.common_color_10139);
            ai.i(bVar.cAL, d.e.common_color_10139);
            ai.i(bVar.cAI, d.e.cp_bg_line_k);
            ai.i(bVar.cAK, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) blVar;
        String str3 = zVar.WS;
        if (!StringUtils.isNull(str3)) {
            bVar.cAH.setVisibility(0);
            bVar.bFM.setVisibility(8);
            bVar.cAH.setIsRound(true);
            bVar.cAH.setUserId(blVar.getAuthor().getUserId());
            bVar.cAH.setImageDrawable(null);
            bVar.cAH.c(str3, 10, false);
        }
        bVar.cAI.setText(zVar.userName);
        bVar.cAJ.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cAK.setText(Html.fromHtml(str2));
        bVar.cAL.setText(zVar.WT);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cAR.setVisibility(0);
                bVar.cAM.setVisibility(8);
                bVar.cAN.setVisibility(8);
                bVar.cAO.setVisibility(8);
                bVar.cAP.setVisibility(8);
                bVar.cAQ.setVisibility(8);
                bVar.cAR.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cAR.setVisibility(8);
                bVar.cAM.setVisibility(8);
                bVar.cAN.setVisibility(8);
                bVar.cAO.setVisibility(8);
                bVar.cAP.setVisibility(0);
                bVar.cAQ.setVisibility(8);
                bVar.cBb.c(zVar.pics.get(0), 10, false);
                bVar.cBc.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cAR.setVisibility(8);
                bVar.cAM.setVisibility(0);
                bVar.cAN.setVisibility(8);
                bVar.cAO.setVisibility(8);
                bVar.cAP.setVisibility(8);
                bVar.cAQ.setVisibility(8);
                bVar.cAS.c(zVar.pics.get(0), 10, false);
                bVar.cAT.c(zVar.pics.get(1), 10, false);
                bVar.cAU.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cAR.setVisibility(8);
                bVar.cAM.setVisibility(8);
                bVar.cAN.setVisibility(8);
                bVar.cAO.setVisibility(8);
                bVar.cAP.setVisibility(0);
                bVar.cAQ.setVisibility(0);
                bVar.cBb.c(zVar.pics.get(0), 10, false);
                bVar.cBc.c(zVar.pics.get(1), 10, false);
                bVar.cBd.c(zVar.pics.get(2), 10, false);
                bVar.cBe.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cAR.setVisibility(8);
                bVar.cAM.setVisibility(0);
                bVar.cAN.setVisibility(8);
                bVar.cAO.setVisibility(8);
                bVar.cAP.setVisibility(0);
                bVar.cAQ.setVisibility(8);
                bVar.cBb.c(zVar.pics.get(0), 10, false);
                bVar.cBc.c(zVar.pics.get(1), 10, false);
                bVar.cAS.c(zVar.pics.get(2), 10, false);
                bVar.cAT.c(zVar.pics.get(3), 10, false);
                bVar.cAU.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cAR.setVisibility(8);
                bVar.cAM.setVisibility(0);
                bVar.cAN.setVisibility(0);
                bVar.cAO.setVisibility(8);
                bVar.cAP.setVisibility(8);
                bVar.cAQ.setVisibility(8);
                bVar.cAS.c(zVar.pics.get(0), 10, false);
                bVar.cAT.c(zVar.pics.get(1), 10, false);
                bVar.cAU.c(zVar.pics.get(2), 10, false);
                bVar.cAV.c(zVar.pics.get(3), 10, false);
                bVar.cAW.c(zVar.pics.get(4), 10, false);
                bVar.cAX.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cAR.setVisibility(8);
                bVar.cAM.setVisibility(0);
                bVar.cAN.setVisibility(0);
                bVar.cAO.setVisibility(0);
                bVar.cAP.setVisibility(8);
                bVar.cAQ.setVisibility(8);
                bVar.cAS.c(zVar.pics.get(0), 10, false);
                bVar.cAT.c(zVar.pics.get(1), 10, false);
                bVar.cAU.c(zVar.pics.get(2), 10, false);
                bVar.cAV.c(zVar.pics.get(3), 10, false);
                bVar.cAW.c(zVar.pics.get(4), 10, false);
                bVar.cAX.c(zVar.pics.get(5), 10, false);
                bVar.cAY.c(zVar.pics.get(6), 10, false);
                bVar.cAZ.c(zVar.pics.get(7), 10, false);
                bVar.cBa.c(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!at.wf().a(a.this.alI, "", new String[]{str4}, false, null, true) && !at.wf().ej(str4)) {
                    a.this.alI.showToast(d.l.pluginstatus_tip_unknown);
                }
                TiebaStatic.log(new aj("c11683").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        });
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.alI, LayoutInflater.from(this.mContext).inflate(d.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bl blVar, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, blVar, bVar);
        return a(i, view, blVar, bVar);
    }
}
