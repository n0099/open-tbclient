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
            ai.k(bVar.cCD, d.e.cp_bg_line_c_1);
            ai.i(bVar.cCG, d.e.cp_cont_e);
            ai.i(bVar.cCI, d.e.cp_cont_e);
            ai.i(bVar.cCF, d.e.cp_cont_b);
            ai.i(bVar.cCH, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            ai.k(bVar.mRootView, d.e.cp_bg_line_d);
            ai.k(bVar.cCD, d.e.cp_bg_line_c);
            ai.i(bVar.cCG, d.e.common_color_10139);
            ai.i(bVar.cCI, d.e.common_color_10139);
            ai.i(bVar.cCF, d.e.cp_bg_line_k);
            ai.i(bVar.cCH, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) blVar;
        String str3 = zVar.WU;
        if (!StringUtils.isNull(str3)) {
            bVar.cCE.setVisibility(0);
            bVar.bGv.setVisibility(8);
            bVar.cCE.setIsRound(true);
            bVar.cCE.setUserId(blVar.getAuthor().getUserId());
            bVar.cCE.setImageDrawable(null);
            bVar.cCE.c(str3, 10, false);
        }
        bVar.cCF.setText(zVar.userName);
        bVar.cCG.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cCH.setText(Html.fromHtml(str2));
        bVar.cCI.setText(zVar.WV);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cCO.setVisibility(0);
                bVar.cCJ.setVisibility(8);
                bVar.cCK.setVisibility(8);
                bVar.cCL.setVisibility(8);
                bVar.cCM.setVisibility(8);
                bVar.cCN.setVisibility(8);
                bVar.cCO.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cCO.setVisibility(8);
                bVar.cCJ.setVisibility(8);
                bVar.cCK.setVisibility(8);
                bVar.cCL.setVisibility(8);
                bVar.cCM.setVisibility(0);
                bVar.cCN.setVisibility(8);
                bVar.cCY.c(zVar.pics.get(0), 10, false);
                bVar.cCZ.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cCO.setVisibility(8);
                bVar.cCJ.setVisibility(0);
                bVar.cCK.setVisibility(8);
                bVar.cCL.setVisibility(8);
                bVar.cCM.setVisibility(8);
                bVar.cCN.setVisibility(8);
                bVar.cCP.c(zVar.pics.get(0), 10, false);
                bVar.cCQ.c(zVar.pics.get(1), 10, false);
                bVar.cCR.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cCO.setVisibility(8);
                bVar.cCJ.setVisibility(8);
                bVar.cCK.setVisibility(8);
                bVar.cCL.setVisibility(8);
                bVar.cCM.setVisibility(0);
                bVar.cCN.setVisibility(0);
                bVar.cCY.c(zVar.pics.get(0), 10, false);
                bVar.cCZ.c(zVar.pics.get(1), 10, false);
                bVar.cDa.c(zVar.pics.get(2), 10, false);
                bVar.cDb.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cCO.setVisibility(8);
                bVar.cCJ.setVisibility(0);
                bVar.cCK.setVisibility(8);
                bVar.cCL.setVisibility(8);
                bVar.cCM.setVisibility(0);
                bVar.cCN.setVisibility(8);
                bVar.cCY.c(zVar.pics.get(0), 10, false);
                bVar.cCZ.c(zVar.pics.get(1), 10, false);
                bVar.cCP.c(zVar.pics.get(2), 10, false);
                bVar.cCQ.c(zVar.pics.get(3), 10, false);
                bVar.cCR.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cCO.setVisibility(8);
                bVar.cCJ.setVisibility(0);
                bVar.cCK.setVisibility(0);
                bVar.cCL.setVisibility(8);
                bVar.cCM.setVisibility(8);
                bVar.cCN.setVisibility(8);
                bVar.cCP.c(zVar.pics.get(0), 10, false);
                bVar.cCQ.c(zVar.pics.get(1), 10, false);
                bVar.cCR.c(zVar.pics.get(2), 10, false);
                bVar.cCS.c(zVar.pics.get(3), 10, false);
                bVar.cCT.c(zVar.pics.get(4), 10, false);
                bVar.cCU.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cCO.setVisibility(8);
                bVar.cCJ.setVisibility(0);
                bVar.cCK.setVisibility(0);
                bVar.cCL.setVisibility(0);
                bVar.cCM.setVisibility(8);
                bVar.cCN.setVisibility(8);
                bVar.cCP.c(zVar.pics.get(0), 10, false);
                bVar.cCQ.c(zVar.pics.get(1), 10, false);
                bVar.cCR.c(zVar.pics.get(2), 10, false);
                bVar.cCS.c(zVar.pics.get(3), 10, false);
                bVar.cCT.c(zVar.pics.get(4), 10, false);
                bVar.cCU.c(zVar.pics.get(5), 10, false);
                bVar.cCV.c(zVar.pics.get(6), 10, false);
                bVar.cCW.c(zVar.pics.get(7), 10, false);
                bVar.cCX.c(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!at.wf().a(a.this.oV, "", new String[]{str4}, false, null, true) && !at.wf().ej(str4)) {
                    a.this.oV.showToast(d.l.pluginstatus_tip_unknown);
                }
                TiebaStatic.log(new aj("c11683").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        });
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ae */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.oV, LayoutInflater.from(this.mContext).inflate(d.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
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
