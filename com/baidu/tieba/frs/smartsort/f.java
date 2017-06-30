package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    final /* synthetic */ e cnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cnp = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aT */
    public void m(String str, String str2) {
        ArrayList kg;
        HashMap hashMap;
        if (str2 != null) {
            String ahe = this.cnp.ahe();
            kg = this.cnp.kg(str2);
            hashMap = this.cnp.cnn;
            hashMap.put(ahe, kg);
        }
        this.cnp.cng = true;
    }
}
