package com.baidu.tieba.frs.f;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements o.a<String> {
    final /* synthetic */ f bMJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bMJ = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aI */
    public void m(String str, String str2) {
        ArrayList iK;
        HashMap hashMap;
        if (str2 != null) {
            String abg = this.bMJ.abg();
            iK = this.bMJ.iK(str2);
            hashMap = this.bMJ.bMH;
            hashMap.put(abg, iK);
        }
        this.bMJ.bMz = true;
    }
}
