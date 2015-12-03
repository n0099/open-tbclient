package com.baidu.tieba.gift.giftTab;

import com.baidu.tieba.gift.giftTab.ad;
/* loaded from: classes.dex */
class r implements ad.f {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    @Override // com.baidu.tieba.gift.giftTab.ad.f
    public void hv(int i) {
        z zVar;
        ad adVar;
        zVar = this.bvt.bvg;
        zVar.hx(i);
        adVar = this.bvt.bvf;
        adVar.Tl();
    }
}
