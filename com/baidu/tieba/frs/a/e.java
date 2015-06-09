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
public class e extends av<com.baidu.tbadk.core.data.c, f> {
    public e(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public f a(ViewGroup viewGroup) {
        return new f(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.frs_locality_bar_single_replenish, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.aPA.setPadding(0, i - this.aMV == 0 ? this.aKk : this.aKl, 0, 0);
        this.aMl.getLayoutMode().ab(this.mSkinType == 1);
        this.aMl.getLayoutMode().j(view);
        if (!cVar.PJ) {
            cVar.PJ = true;
            this.aMl.a(cVar, "show");
            this.aMl.b(cVar, "show");
        }
        if (n.qc().qe()) {
            fVar.aBl.setVisibility(0);
            fVar.aBl.c(cVar.PH.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.aBl.setVisibility(8);
        }
        if (n.qc().qg() && !TextUtils.isEmpty(cVar.PH.PM)) {
            fVar.aPC.setVisibility(0);
            fVar.aPC.c(cVar.PH.PM, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.aPC.setVisibility(8);
        }
        fVar.aHI.setText(cVar.PH.userName);
        if (StringUtils.isNull(cVar.PH.PL)) {
            fVar.aiA.setVisibility(8);
        } else {
            fVar.aiA.setVisibility(0);
            fVar.aiA.setText(cVar.PH.PL);
        }
        if (StringUtils.isNull(cVar.PH.PP)) {
            fVar.aPD.setVisibility(8);
        } else {
            fVar.aPD.setVisibility(0);
            fVar.aPD.setText(cVar.PH.PP);
        }
        if (StringUtils.isNull(cVar.PH.PQ)) {
            fVar.aPE.setVisibility(8);
        } else {
            fVar.aPE.setVisibility(0);
            fVar.aPE.setText(cVar.PH.PQ);
        }
        return view;
    }
}
