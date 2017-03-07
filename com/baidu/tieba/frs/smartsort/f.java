package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    final /* synthetic */ e caj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.caj = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aL */
    public void m(String str, String str2) {
        ArrayList iO;
        HashMap hashMap;
        if (str2 != null) {
            String adk = this.caj.adk();
            iO = this.caj.iO(str2);
            hashMap = this.caj.cah;
            hashMap.put(adk, iO);
        }
        this.caj.bZZ = true;
    }
}
