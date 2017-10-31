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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d;
import com.baidu.tieba.frs.e.c;
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
            aj.k(bVar.mRootView, d.C0080d.cp_bg_line_d_1);
            aj.k(bVar.cTM, d.C0080d.cp_bg_line_c_1);
            aj.i(bVar.cTP, d.C0080d.cp_cont_e);
            aj.i(bVar.cTR, d.C0080d.cp_cont_e);
            aj.i(bVar.cTO, d.C0080d.cp_cont_b);
            aj.i(bVar.cTQ, d.C0080d.cp_cont_b);
            str = "#4f93ef";
        } else {
            aj.k(bVar.mRootView, d.C0080d.cp_bg_line_d);
            aj.k(bVar.cTM, d.C0080d.cp_bg_line_c);
            aj.i(bVar.cTP, d.C0080d.common_color_10139);
            aj.i(bVar.cTR, d.C0080d.common_color_10139);
            aj.i(bVar.cTO, d.C0080d.cp_bg_line_k);
            aj.i(bVar.cTQ, d.C0080d.cp_bg_line_k);
            str = "#3385ff";
        }
        final z zVar = (z) bhVar;
        String str3 = zVar.Wy;
        if (!StringUtils.isNull(str3)) {
            bVar.cTN.setVisibility(0);
            bVar.bQP.setVisibility(8);
            bVar.cTN.setIsRound(true);
            bVar.cTN.setUserId(bhVar.rt().getUserId());
            bVar.cTN.setImageDrawable(null);
            bVar.cTN.startLoad(str3, 10, false);
        }
        bVar.cTO.setText(zVar.userName);
        bVar.cTP.setText(zVar.tips);
        if (StringUtils.isNull(zVar.type)) {
            str2 = zVar.title;
        } else {
            str2 = "<font color='" + str + "'>" + zVar.type + "·</font>" + zVar.title;
        }
        bVar.cTQ.setText(Html.fromHtml(str2));
        bVar.cTR.setText(zVar.Wz);
        if (zVar.pics != null) {
            int size = zVar.pics.size();
            if (size == 1) {
                bVar.cTX.setVisibility(0);
                bVar.cTS.setVisibility(8);
                bVar.cTT.setVisibility(8);
                bVar.cTU.setVisibility(8);
                bVar.cTV.setVisibility(8);
                bVar.cTW.setVisibility(8);
                bVar.cTX.startLoad(zVar.pics.get(0), 10, false);
            } else if (size == 2) {
                bVar.cTX.setVisibility(8);
                bVar.cTS.setVisibility(8);
                bVar.cTT.setVisibility(8);
                bVar.cTU.setVisibility(8);
                bVar.cTV.setVisibility(0);
                bVar.cTW.setVisibility(8);
                bVar.cUh.startLoad(zVar.pics.get(0), 10, false);
                bVar.cUi.startLoad(zVar.pics.get(1), 10, false);
            } else if (size == 3) {
                bVar.cTX.setVisibility(8);
                bVar.cTS.setVisibility(0);
                bVar.cTT.setVisibility(8);
                bVar.cTU.setVisibility(8);
                bVar.cTV.setVisibility(8);
                bVar.cTW.setVisibility(8);
                bVar.cTY.startLoad(zVar.pics.get(0), 10, false);
                bVar.cTZ.startLoad(zVar.pics.get(1), 10, false);
                bVar.cUa.startLoad(zVar.pics.get(2), 10, false);
            } else if (size == 4) {
                bVar.cTX.setVisibility(8);
                bVar.cTS.setVisibility(8);
                bVar.cTT.setVisibility(8);
                bVar.cTU.setVisibility(8);
                bVar.cTV.setVisibility(0);
                bVar.cTW.setVisibility(0);
                bVar.cUh.startLoad(zVar.pics.get(0), 10, false);
                bVar.cUi.startLoad(zVar.pics.get(1), 10, false);
                bVar.cUj.startLoad(zVar.pics.get(2), 10, false);
                bVar.cUk.startLoad(zVar.pics.get(3), 10, false);
            } else if (size == 5) {
                bVar.cTX.setVisibility(8);
                bVar.cTS.setVisibility(0);
                bVar.cTT.setVisibility(8);
                bVar.cTU.setVisibility(8);
                bVar.cTV.setVisibility(0);
                bVar.cTW.setVisibility(8);
                bVar.cUh.startLoad(zVar.pics.get(0), 10, false);
                bVar.cUi.startLoad(zVar.pics.get(1), 10, false);
                bVar.cTY.startLoad(zVar.pics.get(2), 10, false);
                bVar.cTZ.startLoad(zVar.pics.get(3), 10, false);
                bVar.cUa.startLoad(zVar.pics.get(4), 10, false);
            } else if (size >= 6 && size < 9) {
                bVar.cTX.setVisibility(8);
                bVar.cTS.setVisibility(0);
                bVar.cTT.setVisibility(0);
                bVar.cTU.setVisibility(8);
                bVar.cTV.setVisibility(8);
                bVar.cTW.setVisibility(8);
                bVar.cTY.startLoad(zVar.pics.get(0), 10, false);
                bVar.cTZ.startLoad(zVar.pics.get(1), 10, false);
                bVar.cUa.startLoad(zVar.pics.get(2), 10, false);
                bVar.cUb.startLoad(zVar.pics.get(3), 10, false);
                bVar.cUc.startLoad(zVar.pics.get(4), 10, false);
                bVar.cUd.startLoad(zVar.pics.get(5), 10, false);
            } else if (size >= 9) {
                bVar.cTX.setVisibility(8);
                bVar.cTS.setVisibility(0);
                bVar.cTT.setVisibility(0);
                bVar.cTU.setVisibility(0);
                bVar.cTV.setVisibility(8);
                bVar.cTW.setVisibility(8);
                bVar.cTY.startLoad(zVar.pics.get(0), 10, false);
                bVar.cTZ.startLoad(zVar.pics.get(1), 10, false);
                bVar.cUa.startLoad(zVar.pics.get(2), 10, false);
                bVar.cUb.startLoad(zVar.pics.get(3), 10, false);
                bVar.cUc.startLoad(zVar.pics.get(4), 10, false);
                bVar.cUd.startLoad(zVar.pics.get(5), 10, false);
                bVar.cUe.startLoad(zVar.pics.get(6), 10, false);
                bVar.cUf.startLoad(zVar.pics.get(7), 10, false);
                bVar.cUg.startLoad(zVar.pics.get(8), 10, false);
            }
        }
        bVar.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.h.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str4 = zVar.linkUrl;
                if (!av.vI().a(a.this.mPageContext, "", new String[]{str4}, false, null, true) && !av.vI().ed(str4)) {
                    a.this.mPageContext.showToast(d.j.pluginstatus_tip_unknown);
                }
                TiebaStatic.log(new ak("c11683").ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
            }
        });
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aE */
    public b onCreateViewHolder(ViewGroup viewGroup) {
        return new b(this.mPageContext, LayoutInflater.from(this.mContext).inflate(d.h.frs_wefan_item, (ViewGroup) null), this.mPageId);
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
