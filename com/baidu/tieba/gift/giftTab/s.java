package com.baidu.tieba.gift.giftTab;

import com.baidu.tieba.gift.giftTab.ad;
/* loaded from: classes.dex */
class s implements ad.e {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    @Override // com.baidu.tieba.gift.giftTab.ad.e
    public void Tf() {
        z zVar;
        String str;
        long j;
        ad adVar;
        zVar = this.bvt.bvg;
        str = this.bvt.mFrom;
        j = this.bvt.mToUserId;
        zVar.j(str, j);
        adVar = this.bvt.bvf;
        adVar.Tl();
    }
}
