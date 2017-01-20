package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a bSQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bSQ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aN */
    public void m(String str, String str2) {
        ArrayList iX;
        HashMap hashMap;
        if (str2 != null) {
            iX = this.bSQ.iX(str2);
            String acn = this.bSQ.acn();
            hashMap = this.bSQ.bSO;
            hashMap.put(acn, iX);
        }
        this.bSQ.bSN = true;
    }
}
