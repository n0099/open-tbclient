package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    final /* synthetic */ e cbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cbb = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aO */
    public void m(String str, String str2) {
        ArrayList iU;
        HashMap hashMap;
        if (str2 != null) {
            String aef = this.cbb.aef();
            iU = this.cbb.iU(str2);
            hashMap = this.cbb.caZ;
            hashMap.put(aef, iU);
        }
        this.cbb.caR = true;
    }
}
