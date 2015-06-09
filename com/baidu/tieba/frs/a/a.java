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
public class a extends av<com.baidu.tbadk.core.data.c, b> {
    public a(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public b a(ViewGroup viewGroup) {
        return new b(com.baidu.adp.lib.g.b.hr().inflate(this.mContext, r.frs_locality_bar_big_image, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.aPA.setPadding(0, i - this.aMV == 0 ? this.aKk : this.aKl, 0, 0);
        this.aMl.getLayoutMode().ab(this.mSkinType == 1);
        this.aMl.getLayoutMode().j(view);
        if (!cVar.PJ) {
            cVar.PJ = true;
            this.aMl.a(cVar, "show");
            this.aMl.b(cVar, "show");
        }
        if (n.qc().qe()) {
            bVar.aBl.setVisibility(0);
            bVar.aBl.c(cVar.PH.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.aBl.setVisibility(8);
        }
        if (n.qc().qg() && !TextUtils.isEmpty(cVar.PH.PM)) {
            bVar.aPC.setVisibility(0);
            bVar.aPC.c(cVar.PH.PM, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.aPC.setVisibility(8);
        }
        bVar.aHI.setText(cVar.PH.userName);
        if (StringUtils.isNull(cVar.PH.PL)) {
            bVar.aiA.setVisibility(8);
        } else {
            bVar.aiA.setVisibility(0);
            bVar.aiA.setText(cVar.PH.PL);
        }
        return view;
    }
}
