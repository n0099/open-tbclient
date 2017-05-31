package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a ceU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ceU = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aM */
    public void m(String str, String str2) {
        ArrayList jj;
        HashMap hashMap;
        if (str2 != null) {
            jj = this.ceU.jj(str2);
            String adm = this.ceU.adm();
            hashMap = this.ceU.ceS;
            hashMap.put(adm, jj);
        }
        this.ceU.ceR = true;
    }
}
