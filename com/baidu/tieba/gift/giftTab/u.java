package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.gift.giftTab.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
class u implements z.b {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    @Override // com.baidu.tieba.gift.giftTab.z.b
    public void a(int i, String str, boolean z, String str2, ArrayList<i> arrayList, ArrayList<c> arrayList2, ArrayList<k> arrayList3) {
        ad adVar;
        ad adVar2;
        ad adVar3;
        if (i != 0 && !StringUtils.isNull(str)) {
            this.bvt.showToast(str);
        }
        this.bvt.addFreeUrl = str2;
        adVar = this.bvt.bvf;
        if (adVar != null) {
            adVar2 = this.bvt.bvf;
            adVar2.a(z, arrayList, arrayList2, arrayList3);
            adVar3 = this.bvt.bvf;
            adVar3.hK(str2);
        }
    }
}
