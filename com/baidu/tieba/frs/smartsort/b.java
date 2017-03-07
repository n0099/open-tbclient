package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a cac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cac = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aL */
    public void m(String str, String str2) {
        ArrayList iO;
        HashMap hashMap;
        if (str2 != null) {
            iO = this.cac.iO(str2);
            String adk = this.cac.adk();
            hashMap = this.cac.caa;
            hashMap.put(adk, iO);
        }
        this.cac.bZZ = true;
    }
}
