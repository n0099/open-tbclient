package com.baidu.tieba.gift.giftTab;

import com.baidu.tieba.gift.giftTab.f;
import com.baidu.tieba.gift.giftTab.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements f.a {
    final /* synthetic */ z bvF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(z zVar) {
        this.bvF = zVar;
    }

    @Override // com.baidu.tieba.gift.giftTab.f.a
    public void b(int i, String str, int i2) {
        z.a aVar;
        z.a aVar2;
        int i3;
        if (i == 0) {
            this.bvF.freeChance = i2;
            aVar = this.bvF.bvp;
            if (aVar != null) {
                aVar2 = this.bvF.bvp;
                i3 = this.bvF.freeChance;
                aVar2.hw(i3);
            }
        }
    }
}
