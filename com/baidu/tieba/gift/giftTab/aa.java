package com.baidu.tieba.gift.giftTab;

import com.baidu.tieba.gift.giftTab.d;
import com.baidu.tieba.gift.giftTab.z;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements d.a {
    final /* synthetic */ z bvF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bvF = zVar;
    }

    @Override // com.baidu.tieba.gift.giftTab.d.a
    public void a(int i, String str, int i2, String str2, ArrayList<c> arrayList, ArrayList<com.baidu.tbadk.core.data.l> arrayList2, ArrayList<k> arrayList3) {
        z.b bVar;
        z.b bVar2;
        String str3;
        ArrayList<i> arrayList4;
        ArrayList<c> arrayList5;
        ArrayList<k> arrayList6;
        HashMap hashMap;
        int i3 = 0;
        if (i == 0) {
            if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                i3 = arrayList.get(0).getCategoryId();
            }
            this.bvF.bvz = arrayList;
            hashMap = this.bvF.bvB;
            hashMap.put(Integer.valueOf(i3), arrayList2);
            this.bvF.bvA = arrayList3;
            this.bvF.addFreeUrl = str2;
            this.bvF.freeChance = i2;
            this.bvF.Th();
        }
        bVar = this.bvF.bvq;
        if (bVar != null) {
            bVar2 = this.bvF.bvq;
            str3 = this.bvF.addFreeUrl;
            arrayList4 = this.bvF.bvy;
            arrayList5 = this.bvF.bvz;
            arrayList6 = this.bvF.bvA;
            bVar2.a(i, str, true, str3, arrayList4, arrayList5, arrayList6);
        }
    }
}
