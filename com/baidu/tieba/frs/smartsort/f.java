package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    final /* synthetic */ e bYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bYK = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aP */
    public void m(String str, String str2) {
        ArrayList iT;
        HashMap hashMap;
        if (str2 != null) {
            String ade = this.bYK.ade();
            iT = this.bYK.iT(str2);
            hashMap = this.bYK.bYI;
            hashMap.put(ade, iT);
        }
        this.bYK.bYA = true;
    }
}
