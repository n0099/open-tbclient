package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bMC = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aI */
    public void m(String str, String str2) {
        ArrayList iK;
        HashMap hashMap;
        if (str2 != null) {
            iK = this.bMC.iK(str2);
            String abg = this.bMC.abg();
            hashMap = this.bMC.bMA;
            hashMap.put(abg, iK);
        }
        this.bMC.bMz = true;
    }
}
