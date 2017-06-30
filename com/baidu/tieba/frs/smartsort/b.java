package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a cnj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cnj = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aT */
    public void m(String str, String str2) {
        ArrayList kg;
        HashMap hashMap;
        if (str2 != null) {
            kg = this.cnj.kg(str2);
            String ahe = this.cnj.ahe();
            hashMap = this.cnj.cnh;
            hashMap.put(ahe, kg);
        }
        this.cnj.cng = true;
    }
}
