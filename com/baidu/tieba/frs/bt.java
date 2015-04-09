package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements com.baidu.adp.lib.e.c<bv> {
    final /* synthetic */ bs aMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.aMm = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: KC */
    public bv hA() {
        Context context;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        context = this.aMm.mContext;
        View inflate = hH.inflate(context, com.baidu.tieba.w.frs_item_livecard, null);
        bv bvVar = new bv(this.aMm);
        bvVar.aIA = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.live_card_layout);
        bvVar.aIB = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.v.item_card);
        frsActivity = this.aMm.aKd;
        frsActivity.getLayoutMode().X(this.aMm.mSkinType == 1);
        frsActivity2 = this.aMm.aKd;
        frsActivity2.getLayoutMode().h(inflate);
        bvVar.aiy = this.aMm.mSkinType;
        return bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(bv bvVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public bv l(bv bvVar) {
        return bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public bv m(bv bvVar) {
        return bvVar;
    }
}
