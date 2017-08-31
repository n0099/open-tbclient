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
            aj.k(bVar.cIT, d.e.cp_bg_line_c_1);
            aj.i(bVar.cIW, d.e.cp_cont_e);
            aj.i(bVar.cIY, d.e.cp_cont_e);
            aj.i(bVar.cIV, d.e.cp_cont_b);
            aj.i(bVar.cIX, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            aj.k(bVar.mRootView, d.e.cp_bg_line_d);
            aj.k(bVar.cIT, d.e.cp_bg_line_c);
            aj.i(bVar.cIW, d.e.common_color_10139);
            aj.i(bVar.cIY, d.e.common_color_10139);
            aj.i(bVar.cIV, d.e.cp_bg_line_k);
            aj.i(bVar.cIX, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) bjVar;
        String str3 = zVar.We;
        if (!StringUtils.isNull(str3)) {
            bVar.cIU.setVisibility(0);
            bVar.bJq.setVisibility(8);
            bVar.cIU.setIsRound(true);
            bVar.cIU.setUserId(bjVar.getAuthor().getUserId());
            bVar.cIU.setImageDrawable(null);
            bVar.cIU.c(str3, 10, false);
        }
        bVar.cIV.setText(zVar.userName);
        bVar.cIW.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cIX.setText(Html.fromHtml(str2));
        bVar.cIY.setText(zVar.Wf);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cJe.setVisibility(0);
                bVar.cIZ.setVisibility(8);
                bVar.cJa.setVisibility(8);
                bVar.cJb.setVisibility(8);
                bVar.cJc.setVisibility(8);
                bVar.cJd.setVisibility(8);
                bVar.cJe.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cJe.setVisibility(8);
                bVar.cIZ.setVisibility(8);
                bVar.cJa.setVisibility(8);
                bVar.cJb.setVisibility(8);
                bVar.cJc.setVisibility(0);
                bVar.cJd.setVisibility(8);
                bVar.cJo.c(zVar.pics.get(0), 10, false);
                bVar.cJp.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cJe.setVisibility(8);
                bVar.cIZ.setVisibility(0);
                bVar.cJa.setVisibility(8);
                bVar.cJb.setVisibility(8);
                bVar.cJc.setVisibility(8);
                bVar.cJd.setVisibility(8);
                bVar.cJf.c(zVar.pics.get(0), 10, false);
                bVar.cJg.c(zVar.pics.get(1), 10, false);
                bVar.cJh.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cJe.setVisibility(8);
                bVar.cIZ.setVisibility(8);
                bVar.cJa.setVisibility(8);
                bVar.cJb.setVisibility(8);
                bVar.cJc.setVisibility(0);
                bVar.cJd.setVisibility(0);
                bVar.cJo.c(zVar.pics.get(0), 10, false);
                bVar.cJp.c(zVar.pics.get(1), 10, false);
                bVar.cJq.c(zVar.pics.get(2), 10, false);
                bVar.cJr.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cJe.setVisibility(8);
                bVar.cIZ.setVisibility(0);
                bVar.cJa.setVisibility(8);
                bVar.cJb.setVisibility(8);
                bVar.cJc.setVisibility(0);
                bVar.cJd.setVisibility(8);
                bVar.cJo.c(zVar.pics.get(0), 10, false);
                bVar.cJp.c(zVar.pics.get(1), 10, false);
                bVar.cJf.c(zVar.pics.get(2), 10, false);
                bVar.cJg.c(zVar.pics.get(3), 10, false);
                bVar.cJh.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cJe.setVisibility(8);
                bVar.cIZ.setVisibility(0);
                bVar.cJa.setVisibility(0);
                bVar.cJb.setVisibility(8);
                bVar.cJc.setVisibility(8);
                bVar.cJd.setVisibility(8);
                bVar.cJf.c(zVar.pics.get(0), 10, false);
                bVar.cJg.c(zVar.pics.get(1), 10, false);
                bVar.cJh.c(zVar.pics.get(2), 10, false);
                bVar.cJi.c(zVar.pics.get(3), 10, false);
                bVar.cJj.c(zVar.pics.get(4), 10, false);
                bVar.cJk.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cJe.setVisibility(8);
                bVar.cIZ.setVisibility(0);
                bVar.cJa.setVisibility(0);
                bVar.cJb.setVisibility(0);
                bVar.cJc.setVisibility(8);
                bVar.cJd.setVisibility(8);
                bVar.cJf.c(zVar.pics.get(0), 10, false);
                bVar.cJg.c(zVar.pics.get(1), 10, false);
                bVar.cJh.c(zVar.pics.get(2), 10, false);
                bVar.cJi.c(zVar.pics.get(3), 10, false);
                bVar.cJj.c(zVar.pics.get(4), 10, false);
                bVar.cJk.c(zVar.pics.get(5), 10, false);
                bVar.cJl.c(zVar.pics.get(6), 10, false);
                bVar.cJm.c(zVar.pics.get(7), 10, false);
                bVar.cJn.c(zVar.pics.get(8), 10, false);
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
