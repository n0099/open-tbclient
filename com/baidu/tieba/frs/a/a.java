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
public class a extends av<com.baidu.tbadk.core.data.c, b> {
    public a(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public b a(ViewGroup viewGroup) {
        return new b(com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.frs_locality_bar_big_image, null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.av, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.c cVar, b bVar) {
        super.a(i, view, viewGroup, (ViewGroup) cVar, (com.baidu.tbadk.core.data.c) bVar);
        bVar.aMW.setPadding(0, i - this.aKD == 0 ? this.aHT : this.aHU, 0, 0);
        this.aJT.getLayoutMode().X(this.mSkinType == 1);
        this.aJT.getLayoutMode().h(view);
        if (!cVar.Pl) {
            cVar.Pl = true;
            this.aJT.a(cVar, "show");
            this.aJT.b(cVar, "show");
        }
        if (n.px().pz()) {
            bVar.azr.setVisibility(0);
            bVar.azr.c(cVar.Pk.userPortrait, this.mIsFromCDN ? 13 : 14, false);
        } else {
            bVar.azr.setVisibility(8);
        }
        if (n.px().pB() && !TextUtils.isEmpty(cVar.Pk.Po)) {
            bVar.aMY.setVisibility(0);
            bVar.aMY.c(cVar.Pk.Po, this.mIsFromCDN ? 30 : 31, false);
        } else {
            bVar.aMY.setVisibility(8);
        }
        bVar.aFs.setText(cVar.Pk.userName);
        if (StringUtils.isNull(cVar.Pk.Pn)) {
            bVar.ahr.setVisibility(8);
        } else {
            bVar.ahr.setVisibility(0);
            bVar.ahr.setText(cVar.Pk.Pn);
        }
        return view;
    }
}
