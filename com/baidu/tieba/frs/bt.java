package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements com.baidu.adp.lib.e.c<bv> {
    final /* synthetic */ bs aMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.aMb = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Ks */
    public bv hA() {
        Context context;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.adp.lib.g.b hH = com.baidu.adp.lib.g.b.hH();
        context = this.aMb.mContext;
        View inflate = hH.inflate(context, com.baidu.tieba.w.frs_item_livecard, null);
        bv bvVar = new bv(this.aMb);
        bvVar.aIs = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.live_card_layout);
        bvVar.aIt = (LiveBroadcastCard) inflate.findViewById(com.baidu.tieba.v.item_card);
        frsActivity = this.aMb.aJT;
        frsActivity.getLayoutMode().X(this.aMb.mSkinType == 1);
        frsActivity2 = this.aMb.aJT;
        frsActivity2.getLayoutMode().h(inflate);
        bvVar.aiq = this.aMb.mSkinType;
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
