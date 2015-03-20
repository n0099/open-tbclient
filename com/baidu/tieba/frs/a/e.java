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
public class e extends av<com.baidu.tbadk.core.data.c, f> {
    public e(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public f a(ViewGroup viewGroup) {
        return new f(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.frs_locality_bar_single_replenish, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, f fVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) fVar);
        fVar.aMW.setPadding(0, i - this.aKD == 0 ? this.aHT : this.aHU, 0, 0);
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (!cVar.Pl) {
            cVar.Pl = true;
            this.aJT.a(cVar, "show");
            this.aJT.b(cVar, "show");
        }
        if (n.px().pz()) {
            fVar.azr.setVisibility(0);
            fVar.azr.c(cVar.Pk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            fVar.azr.setVisibility(8);
        }
        if (n.px().pB() && !TextUtils.isEmpty(cVar.Pk.Po)) {
            fVar.aMY.setVisibility(0);
            fVar.aMY.c(cVar.Pk.Po, this.mIsFromCDN ? 30 : 31, false);
        } else {
            fVar.aMY.setVisibility(8);
        }
        fVar.aFs.setText(cVar.Pk.userName);
        if (StringUtils.isNull(cVar.Pk.Pn)) {
            fVar.ahr.setVisibility(8);
        } else {
            fVar.ahr.setVisibility(0);
            fVar.ahr.setText(cVar.Pk.Pn);
        }
        if (StringUtils.isNull(cVar.Pk.Pr)) {
            fVar.aMZ.setVisibility(8);
        } else {
            fVar.aMZ.setVisibility(0);
            fVar.aMZ.setText(cVar.Pk.Pr);
        }
        if (StringUtils.isNull(cVar.Pk.Ps)) {
            fVar.aNa.setVisibility(8);
        } else {
            fVar.aNa.setVisibility(0);
            fVar.aNa.setText(cVar.Pk.Ps);
        }
        return view;
    }
}
