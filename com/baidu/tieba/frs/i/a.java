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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d;
import com.baidu.tieba.frs.f.c;
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
            ai.k(bVar.czl, d.e.cp_bg_line_c_1);
            ai.i(bVar.czo, d.e.cp_cont_e);
            ai.i(bVar.czq, d.e.cp_cont_e);
            ai.i(bVar.czn, d.e.cp_cont_b);
            ai.i(bVar.czp, d.e.cp_cont_b);
            str = "#4f93ef";
        } else {
            ai.k(bVar.mRootView, d.e.cp_bg_line_d);
            ai.k(bVar.czl, d.e.cp_bg_line_c);
            ai.i(bVar.czo, d.e.common_color_10139);
            ai.i(bVar.czq, d.e.common_color_10139);
            ai.i(bVar.czn, d.e.cp_bg_line_k);
            ai.i(bVar.czp, d.e.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) blVar;
        String str3 = zVar.Vw;
        if (!StringUtils.isNull(str3)) {
            bVar.czm.setVisibility(0);
            bVar.bEC.setVisibility(8);
            bVar.czm.setIsRound(true);
            bVar.czm.setUserId(blVar.getAuthor().getUserId());
            bVar.czm.setImageDrawable(null);
            bVar.czm.c(str3, 10, false);
        }
        bVar.czn.setText(zVar.userName);
        bVar.czo.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.czp.setText(Html.fromHtml(str2));
        bVar.czq.setText(zVar.Vx);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.czw.setVisibility(0);
                bVar.czr.setVisibility(8);
                bVar.czs.setVisibility(8);
                bVar.czt.setVisibility(8);
                bVar.czu.setVisibility(8);
                bVar.czv.setVisibility(8);
                bVar.czw.c(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.czw.setVisibility(8);
                bVar.czr.setVisibility(8);
                bVar.czs.setVisibility(8);
                bVar.czt.setVisibility(8);
                bVar.czu.setVisibility(0);
                bVar.czv.setVisibility(8);
                bVar.czG.c(zVar.pics.get(0), 10, false);
                bVar.czH.c(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.czw.setVisibility(8);
                bVar.czr.setVisibility(0);
                bVar.czs.setVisibility(8);
                bVar.czt.setVisibility(8);
                bVar.czu.setVisibility(8);
                bVar.czv.setVisibility(8);
                bVar.czx.c(zVar.pics.get(0), 10, false);
                bVar.czy.c(zVar.pics.get(1), 10, false);
                bVar.czz.c(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.czw.setVisibility(8);
                bVar.czr.setVisibility(8);
                bVar.czs.setVisibility(8);
                bVar.czt.setVisibility(8);
                bVar.czu.setVisibility(0);
                bVar.czv.setVisibility(0);
                bVar.czG.c(zVar.pics.get(0), 10, false);
                bVar.czH.c(zVar.pics.get(1), 10, false);
                bVar.czI.c(zVar.pics.get(2), 10, false);
                bVar.czJ.c(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.czw.setVisibility(8);
                bVar.czr.setVisibility(0);
                bVar.czs.setVisibility(8);
                bVar.czt.setVisibility(8);
                bVar.czu.setVisibility(0);
                bVar.czv.setVisibility(8);
                bVar.czG.c(zVar.pics.get(0), 10, false);
                bVar.czH.c(zVar.pics.get(1), 10, false);
                bVar.czx.c(zVar.pics.get(2), 10, false);
                bVar.czy.c(zVar.pics.get(3), 10, false);
                bVar.czz.c(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.czw.setVisibility(8);
                bVar.czr.setVisibility(0);
                bVar.czs.setVisibility(0);
                bVar.czt.setVisibility(8);
                bVar.czu.setVisibility(8);
                bVar.czv.setVisibility(8);
                bVar.czx.c(zVar.pics.get(0), 10, false);
                bVar.czy.c(zVar.pics.get(1), 10, false);
                bVar.czz.c(zVar.pics.get(2), 10, false);
                bVar.czA.c(zVar.pics.get(3), 10, false);
                bVar.czB.c(zVar.pics.get(4), 10, false);
                bVar.czC.c(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.czw.setVisibility(8);
                bVar.czr.setVisibility(0);
                bVar.czs.setVisibility(0);
                bVar.czt.setVisibility(0);
                bVar.czu.setVisibility(8);
                bVar.czv.setVisibility(8);
                bVar.czx.c(zVar.pics.get(0), 10, false);
                bVar.czy.c(zVar.pics.get(1), 10, false);
                bVar.czz.c(zVar.pics.get(2), 10, false);
                bVar.czA.c(zVar.pics.get(3), 10, false);
                bVar.czB.c(zVar.pics.get(4), 10, false);
                bVar.czC.c(zVar.pics.get(5), 10, false);
                bVar.czD.c(zVar.pics.get(6), 10, false);
                bVar.czE.c(zVar.pics.get(7), 10, false);
                bVar.czF.c(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!at.vV().a(a.this.ako, "", new String[]{str4}, false, null, true) && !at.vV().ed(str4)) {
                    a.this.ako.showToast(d.l.pluginstatus_tip_unknown);
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
        return new b(this.ako, LayoutInflater.from(this.mContext).inflate(d.j.frs_wefan_item, (ViewGroup) null), this.mPageId);
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
