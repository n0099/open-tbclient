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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d;
import com.baidu.tieba.frs.f.c;
/* loaded from: classes.dex */
public class a extends d<bj, b> implements c {
    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
    }

    private View a(int i, View view, bj bjVar, b bVar) {
        String str;
        String str2;
        if (bjVar == null || !(bjVar instanceof z)) {
            return null;
        }
        if (this.mSkinType == 1) {
            aj.k(bVar.mRootView, d.e.cp_bg_line_d_1);
            aj.k(bVar.cJN, d.e.cp_bg_line_c_1);
            aj.i(bVar.cJQ, d.e.cp_cont_e);
            aj.i(bVar.cJS, d.e.cp_cont_e);
            aj.i(bVar.cJP, d.e.cp_cont_b);
            aj.i(bVar.cJR, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aj.k(bVar.mRootView, d.e.cp_bg_line_d);
            aj.k(bVar.cJN, d.e.cp_bg_line_c);
            aj.i(bVar.cJQ, d.e.common_color_10139);
            aj.i(bVar.cJS, d.e.common_color_10139);
            aj.i(bVar.cJP, d.e.cp_bg_line_k);
            aj.i(bVar.cJR, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) bjVar;
        String str3 = zVar.We;
        if (!StringUtils.isNull(str3)) {
            bVar.cJO.setVisibility(0);
            bVar.bKh.setVisibility(8);
            bVar.cJO.setIsRound(true);
            bVar.cJO.setUserId(bjVar.getAuthor().getUserId());
            bVar.cJO.setImageDrawable(null);
            bVar.cJO.c(str3, 10, false);
        }
        bVar.cJP.setText(zVar.userName);
        bVar.cJQ.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cJR.setText(Html.fromHtml(str2));
        bVar.cJS.setText(zVar.Wf);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cJY.setVisibility(0);
                bVar.cJT.setVisibility(8);
                bVar.cJU.setVisibility(8);
                bVar.cJV.setVisibility(8);
                bVar.cJW.setVisibility(8);
                bVar.cJX.setVisibility(8);
                bVar.cJY.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cJY.setVisibility(8);
                bVar.cJT.setVisibility(8);
                bVar.cJU.setVisibility(8);
                bVar.cJV.setVisibility(8);
                bVar.cJW.setVisibility(0);
                bVar.cJX.setVisibility(8);
                bVar.cKi.c(zVar.pics.get(0), 10, false);
                bVar.cKj.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cJY.setVisibility(8);
                bVar.cJT.setVisibility(0);
                bVar.cJU.setVisibility(8);
                bVar.cJV.setVisibility(8);
                bVar.cJW.setVisibility(8);
                bVar.cJX.setVisibility(8);
                bVar.cJZ.c(zVar.pics.get(0), 10, false);
                bVar.cKa.c(zVar.pics.get(1), 10, false);
                bVar.cKb.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cJY.setVisibility(8);
                bVar.cJT.setVisibility(8);
                bVar.cJU.setVisibility(8);
                bVar.cJV.setVisibility(8);
                bVar.cJW.setVisibility(0);
                bVar.cJX.setVisibility(0);
                bVar.cKi.c(zVar.pics.get(0), 10, false);
                bVar.cKj.c(zVar.pics.get(1), 10, false);
                bVar.cKk.c(zVar.pics.get(2), 10, false);
                bVar.cKl.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cJY.setVisibility(8);
                bVar.cJT.setVisibility(0);
                bVar.cJU.setVisibility(8);
                bVar.cJV.setVisibility(8);
                bVar.cJW.setVisibility(0);
                bVar.cJX.setVisibility(8);
                bVar.cKi.c(zVar.pics.get(0), 10, false);
                bVar.cKj.c(zVar.pics.get(1), 10, false);
                bVar.cJZ.c(zVar.pics.get(2), 10, false);
                bVar.cKa.c(zVar.pics.get(3), 10, false);
                bVar.cKb.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cJY.setVisibility(8);
                bVar.cJT.setVisibility(0);
                bVar.cJU.setVisibility(0);
                bVar.cJV.setVisibility(8);
                bVar.cJW.setVisibility(8);
                bVar.cJX.setVisibility(8);
                bVar.cJZ.c(zVar.pics.get(0), 10, false);
                bVar.cKa.c(zVar.pics.get(1), 10, false);
                bVar.cKb.c(zVar.pics.get(2), 10, false);
                bVar.cKc.c(zVar.pics.get(3), 10, false);
                bVar.cKd.c(zVar.pics.get(4), 10, false);
                bVar.cKe.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cJY.setVisibility(8);
                bVar.cJT.setVisibility(0);
                bVar.cJU.setVisibility(0);
                bVar.cJV.setVisibility(0);
                bVar.cJW.setVisibility(8);
                bVar.cJX.setVisibility(8);
                bVar.cJZ.c(zVar.pics.get(0), 10, false);
                bVar.cKa.c(zVar.pics.get(1), 10, false);
                bVar.cKb.c(zVar.pics.get(2), 10, false);
                bVar.cKc.c(zVar.pics.get(3), 10, false);
                bVar.cKd.c(zVar.pics.get(4), 10, false);
                bVar.cKe.c(zVar.pics.get(5), 10, false);
                bVar.cKf.c(zVar.pics.get(6), 10, false);
                bVar.cKg.c(zVar.pics.get(7), 10, false);
                bVar.cKh.c(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!au.wd().a(a.this.mF, "", new String[]{str4}, false, null, true) && !au.wd().ef(str4)) {
                    a.this.mF.showToast(d.l.pluginstatus_tip_unknown);
                }
                TiebaStatic.log(new ak("c11683").ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        });
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.mF, LayoutInflater.from(this.mContext).inflate(d.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, bj bjVar, b bVar) {
        super.onFillViewHolder(i, view, viewGroup, bjVar, bVar);
        return a(i, view, bjVar, bVar);
    }
}
