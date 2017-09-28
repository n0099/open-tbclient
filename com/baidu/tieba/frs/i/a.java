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
            aj.k(bVar.cKN, d.e.cp_bg_line_c_1);
            aj.i(bVar.cKQ, d.e.cp_cont_e);
            aj.i(bVar.cKS, d.e.cp_cont_e);
            aj.i(bVar.cKP, d.e.cp_cont_b);
            aj.i(bVar.cKR, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aj.k(bVar.mRootView, d.e.cp_bg_line_d);
            aj.k(bVar.cKN, d.e.cp_bg_line_c);
            aj.i(bVar.cKQ, d.e.common_color_10139);
            aj.i(bVar.cKS, d.e.common_color_10139);
            aj.i(bVar.cKP, d.e.cp_bg_line_k);
            aj.i(bVar.cKR, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) bhVar;
        String str3 = zVar.Ws;
        if (!StringUtils.isNull(str3)) {
            bVar.cKO.setVisibility(0);
            bVar.bJv.setVisibility(8);
            bVar.cKO.setIsRound(true);
            bVar.cKO.setUserId(bhVar.getAuthor().getUserId());
            bVar.cKO.setImageDrawable(null);
            bVar.cKO.c(str3, 10, false);
        }
        bVar.cKP.setText(zVar.userName);
        bVar.cKQ.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cKR.setText(Html.fromHtml(str2));
        bVar.cKS.setText(zVar.Wt);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cKY.setVisibility(0);
                bVar.cKT.setVisibility(8);
                bVar.cKU.setVisibility(8);
                bVar.cKV.setVisibility(8);
                bVar.cKW.setVisibility(8);
                bVar.cKX.setVisibility(8);
                bVar.cKY.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cKY.setVisibility(8);
                bVar.cKT.setVisibility(8);
                bVar.cKU.setVisibility(8);
                bVar.cKV.setVisibility(8);
                bVar.cKW.setVisibility(0);
                bVar.cKX.setVisibility(8);
                bVar.cLi.c(zVar.pics.get(0), 10, false);
                bVar.cLj.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cKY.setVisibility(8);
                bVar.cKT.setVisibility(0);
                bVar.cKU.setVisibility(8);
                bVar.cKV.setVisibility(8);
                bVar.cKW.setVisibility(8);
                bVar.cKX.setVisibility(8);
                bVar.cKZ.c(zVar.pics.get(0), 10, false);
                bVar.cLa.c(zVar.pics.get(1), 10, false);
                bVar.cLb.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cKY.setVisibility(8);
                bVar.cKT.setVisibility(8);
                bVar.cKU.setVisibility(8);
                bVar.cKV.setVisibility(8);
                bVar.cKW.setVisibility(0);
                bVar.cKX.setVisibility(0);
                bVar.cLi.c(zVar.pics.get(0), 10, false);
                bVar.cLj.c(zVar.pics.get(1), 10, false);
                bVar.cLk.c(zVar.pics.get(2), 10, false);
                bVar.cLl.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cKY.setVisibility(8);
                bVar.cKT.setVisibility(0);
                bVar.cKU.setVisibility(8);
                bVar.cKV.setVisibility(8);
                bVar.cKW.setVisibility(0);
                bVar.cKX.setVisibility(8);
                bVar.cLi.c(zVar.pics.get(0), 10, false);
                bVar.cLj.c(zVar.pics.get(1), 10, false);
                bVar.cKZ.c(zVar.pics.get(2), 10, false);
                bVar.cLa.c(zVar.pics.get(3), 10, false);
                bVar.cLb.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cKY.setVisibility(8);
                bVar.cKT.setVisibility(0);
                bVar.cKU.setVisibility(0);
                bVar.cKV.setVisibility(8);
                bVar.cKW.setVisibility(8);
                bVar.cKX.setVisibility(8);
                bVar.cKZ.c(zVar.pics.get(0), 10, false);
                bVar.cLa.c(zVar.pics.get(1), 10, false);
                bVar.cLb.c(zVar.pics.get(2), 10, false);
                bVar.cLc.c(zVar.pics.get(3), 10, false);
                bVar.cLd.c(zVar.pics.get(4), 10, false);
                bVar.cLe.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cKY.setVisibility(8);
                bVar.cKT.setVisibility(0);
                bVar.cKU.setVisibility(0);
                bVar.cKV.setVisibility(0);
                bVar.cKW.setVisibility(8);
                bVar.cKX.setVisibility(8);
                bVar.cKZ.c(zVar.pics.get(0), 10, false);
                bVar.cLa.c(zVar.pics.get(1), 10, false);
                bVar.cLb.c(zVar.pics.get(2), 10, false);
                bVar.cLc.c(zVar.pics.get(3), 10, false);
                bVar.cLd.c(zVar.pics.get(4), 10, false);
                bVar.cLe.c(zVar.pics.get(5), 10, false);
                bVar.cLf.c(zVar.pics.get(6), 10, false);
                bVar.cLg.c(zVar.pics.get(7), 10, false);
                bVar.cLh.c(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!av.vH().a(a.this.mG, "", new String[]{str4}, false, null, true) && !av.vH().dY(str4)) {
                    a.this.mG.showToast(d.l.pluginstatus_tip_unknown);
                }
                TiebaStatic.log(new ak("c11683").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        });
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.mG, LayoutInflater.from(this.mContext).inflate(d.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
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
