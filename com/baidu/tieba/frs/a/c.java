package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class c extends av<com.baidu.tbadk.core.data.c, d> {
    public c(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public d a(ViewGroup viewGroup) {
        return new d(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.frs_locality_bar_normal, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) dVar);
        dVar.aPz.setPadding(0, i - this.aMU == 0 ? this.aKj : this.aKk, 0, 0);
        this.aMk.getLayoutMode().ab(this.mSkinType == 1);
        this.aMk.getLayoutMode().j(view);
        if (!cVar.PJ) {
            cVar.PJ = true;
            this.aMk.a(cVar, "show");
            this.aMk.b(cVar, "show");
        }
        if (n.qc().qe()) {
            dVar.aBk.setVisibility(0);
            dVar.aBk.c(cVar.PH.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.aBk.setVisibility(8);
        }
        if (n.qc().qg() && !TextUtils.isEmpty(cVar.PH.PM)) {
            dVar.aPB.setVisibility(0);
            dVar.aPB.c(cVar.PH.PM, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.aPB.setVisibility(8);
        }
        dVar.aHH.setText(cVar.PH.userName);
        if (StringUtils.isNull(cVar.PH.PL)) {
            dVar.aiA.setVisibility(8);
        } else {
            dVar.aiA.setVisibility(0);
            dVar.aiA.setText(cVar.PH.PL);
        }
        if (StringUtils.isNull(cVar.PH.PP)) {
            dVar.aPC.setVisibility(8);
        } else {
            dVar.aPC.setVisibility(0);
            dVar.aPC.setText(cVar.PH.PP);
        }
        return view;
    }
}
