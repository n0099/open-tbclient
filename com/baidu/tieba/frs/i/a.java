package com.baidu.tieba.frs.i;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d;
import com.baidu.tieba.frs.f.c;
/* loaded from: classes.dex */
public class a extends d<bh, b> implements c {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    private View a(int i, View view, bh bhVar, b bVar) {
        String str;
        String str2;
        if (bhVar == null || !(bhVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aj.k(bVar.mRootView, d.e.cp_bg_line_d_1);
            aj.k(bVar.cKB, d.e.cp_bg_line_c_1);
            aj.i(bVar.cKE, d.e.cp_cont_e);
            aj.i(bVar.cKG, d.e.cp_cont_e);
            aj.i(bVar.cKD, d.e.cp_cont_b);
            aj.i(bVar.cKF, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aj.k(bVar.mRootView, d.e.cp_bg_line_d);
            aj.k(bVar.cKB, d.e.cp_bg_line_c);
            aj.i(bVar.cKE, d.e.common_color_10139);
            aj.i(bVar.cKG, d.e.common_color_10139);
            aj.i(bVar.cKD, d.e.cp_bg_line_k);
            aj.i(bVar.cKF, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) bhVar;
        String str3 = zVar.Wg;
        if (!StringUtils.isNull(str3)) {
            bVar.cKC.setVisibility(0);
            bVar.bJj.setVisibility(8);
            bVar.cKC.setIsRound(true);
            bVar.cKC.setUserId(bhVar.getAuthor().getUserId());
            bVar.cKC.setImageDrawable(null);
            bVar.cKC.c(str3, 10, false);
        }
        bVar.cKD.setText(zVar.userName);
        bVar.cKE.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cKF.setText(Html.fromHtml(str2));
        bVar.cKG.setText(zVar.Wh);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cKM.setVisibility(0);
                bVar.cKH.setVisibility(8);
                bVar.cKI.setVisibility(8);
                bVar.cKJ.setVisibility(8);
                bVar.cKK.setVisibility(8);
                bVar.cKL.setVisibility(8);
                bVar.cKM.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cKM.setVisibility(8);
                bVar.cKH.setVisibility(8);
                bVar.cKI.setVisibility(8);
                bVar.cKJ.setVisibility(8);
                bVar.cKK.setVisibility(0);
                bVar.cKL.setVisibility(8);
                bVar.cKW.c(zVar.pics.get(0), 10, false);
                bVar.cKX.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cKM.setVisibility(8);
                bVar.cKH.setVisibility(0);
                bVar.cKI.setVisibility(8);
                bVar.cKJ.setVisibility(8);
                bVar.cKK.setVisibility(8);
                bVar.cKL.setVisibility(8);
                bVar.cKN.c(zVar.pics.get(0), 10, false);
                bVar.cKO.c(zVar.pics.get(1), 10, false);
                bVar.cKP.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cKM.setVisibility(8);
                bVar.cKH.setVisibility(8);
                bVar.cKI.setVisibility(8);
                bVar.cKJ.setVisibility(8);
                bVar.cKK.setVisibility(0);
                bVar.cKL.setVisibility(0);
                bVar.cKW.c(zVar.pics.get(0), 10, false);
                bVar.cKX.c(zVar.pics.get(1), 10, false);
                bVar.cKY.c(zVar.pics.get(2), 10, false);
                bVar.cKZ.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cKM.setVisibility(8);
                bVar.cKH.setVisibility(0);
                bVar.cKI.setVisibility(8);
                bVar.cKJ.setVisibility(8);
                bVar.cKK.setVisibility(0);
                bVar.cKL.setVisibility(8);
                bVar.cKW.c(zVar.pics.get(0), 10, false);
                bVar.cKX.c(zVar.pics.get(1), 10, false);
                bVar.cKN.c(zVar.pics.get(2), 10, false);
                bVar.cKO.c(zVar.pics.get(3), 10, false);
                bVar.cKP.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cKM.setVisibility(8);
                bVar.cKH.setVisibility(0);
                bVar.cKI.setVisibility(0);
                bVar.cKJ.setVisibility(8);
                bVar.cKK.setVisibility(8);
                bVar.cKL.setVisibility(8);
                bVar.cKN.c(zVar.pics.get(0), 10, false);
                bVar.cKO.c(zVar.pics.get(1), 10, false);
                bVar.cKP.c(zVar.pics.get(2), 10, false);
                bVar.cKQ.c(zVar.pics.get(3), 10, false);
                bVar.cKR.c(zVar.pics.get(4), 10, false);
                bVar.cKS.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cKM.setVisibility(8);
                bVar.cKH.setVisibility(0);
                bVar.cKI.setVisibility(0);
                bVar.cKJ.setVisibility(0);
                bVar.cKK.setVisibility(8);
                bVar.cKL.setVisibility(8);
                bVar.cKN.c(zVar.pics.get(0), 10, false);
                bVar.cKO.c(zVar.pics.get(1), 10, false);
                bVar.cKP.c(zVar.pics.get(2), 10, false);
                bVar.cKQ.c(zVar.pics.get(3), 10, false);
                bVar.cKR.c(zVar.pics.get(4), 10, false);
                bVar.cKS.c(zVar.pics.get(5), 10, false);
                bVar.cKT.c(zVar.pics.get(6), 10, false);
                bVar.cKU.c(zVar.pics.get(7), 10, false);
                bVar.cKV.c(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!av.vA().a(a.this.mH, "", new String[]{str4}, false, null, true) && !av.vA().dX(str4)) {
                    a.this.mH.showToast(d.l.pluginstatus_tip_unknown);
                }
                TiebaStatic.log(new ak("c11683").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        });
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.mH, LayoutInflater.from(this.mContext).inflate(d.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bh bhVar, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, bhVar, bVar);
        return a(i, view, bhVar, bVar);
    }
}
