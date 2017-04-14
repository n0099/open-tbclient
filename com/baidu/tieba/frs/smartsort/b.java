package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a bYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYD = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aP */
    public void m(String str, String str2) {
        ArrayList iT;
        HashMap hashMap;
        if (str2 != null) {
            iT = this.bYD.iT(str2);
            String ade = this.bYD.ade();
            hashMap = this.bYD.bYB;
            hashMap.put(ade, iT);
        }
        this.bYD.bYA = true;
    }
}
