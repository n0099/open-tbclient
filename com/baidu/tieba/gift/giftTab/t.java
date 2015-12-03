package com.baidu.tieba.gift.giftTab;

import com.baidu.tieba.gift.giftTab.z;
/* loaded from: classes.dex */
class t implements z.a {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    @Override // com.baidu.tieba.gift.giftTab.z.a
    public void hw(int i) {
        ad adVar;
        this.bvt.freeChance = i;
        adVar = this.bvt.bvf;
        adVar.hz(i);
        this.bvt.bvl = false;
    }
}
