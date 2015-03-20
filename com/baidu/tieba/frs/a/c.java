package com.baidu.tieba.frs.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.n;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.w;
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
        return new d(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.frs_locality_bar_normal, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, d dVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) dVar);
        dVar.aMW.setPadding(0, i - this.aKD == 0 ? this.aHT : this.aHU, 0, 0);
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (!cVar.Pl) {
            cVar.Pl = true;
            this.aJT.a(cVar, "show");
            this.aJT.b(cVar, "show");
        }
        if (n.px().pz()) {
            dVar.azr.setVisibility(0);
            dVar.azr.c(cVar.Pk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            dVar.azr.setVisibility(8);
        }
        if (n.px().pB() && !TextUtils.isEmpty(cVar.Pk.Po)) {
            dVar.aMY.setVisibility(0);
            dVar.aMY.c(cVar.Pk.Po, this.mIsFromCDN ? 30 : 31, false);
        } else {
            dVar.aMY.setVisibility(8);
        }
        dVar.aFs.setText(cVar.Pk.userName);
        if (StringUtils.isNull(cVar.Pk.Pn)) {
            dVar.ahr.setVisibility(8);
        } else {
            dVar.ahr.setVisibility(0);
            dVar.ahr.setText(cVar.Pk.Pn);
        }
        if (StringUtils.isNull(cVar.Pk.Pr)) {
            dVar.aMZ.setVisibility(8);
        } else {
            dVar.aMZ.setVisibility(0);
            dVar.aMZ.setText(cVar.Pk.Pr);
        }
        return view;
    }
}
