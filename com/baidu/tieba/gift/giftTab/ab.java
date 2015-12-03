package com.baidu.tieba.gift.giftTab;

import com.baidu.tieba.gift.giftTab.a;
import com.baidu.tieba.gift.giftTab.z;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements a.InterfaceC0062a {
    final /* synthetic */ z bvF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.bvF = zVar;
    }

    @Override // com.baidu.tieba.gift.giftTab.a.InterfaceC0062a
    public void a(int i, String str, int i2, ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        z.b bVar;
        z.b bVar2;
        String str2;
        ArrayList<i> arrayList2;
        ArrayList<c> arrayList3;
        ArrayList<k> arrayList4;
        HashMap hashMap;
        if (i == 0) {
            hashMap = this.bvF.bvB;
            hashMap.put(Integer.valueOf(i2), arrayList);
            this.bvF.Th();
        }
        bVar = this.bvF.bvq;
        if (bVar != null) {
            bVar2 = this.bvF.bvq;
            str2 = this.bvF.addFreeUrl;
            arrayList2 = this.bvF.bvy;
            arrayList3 = this.bvF.bvz;
            arrayList4 = this.bvF.bvA;
            bVar2.a(i, str, false, str2, arrayList2, arrayList3, arrayList4);
        }
    }
}
