package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    final /* synthetic */ e bSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bSX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aN */
    public void m(String str, String str2) {
        ArrayList iX;
        HashMap hashMap;
        if (str2 != null) {
            String acn = this.bSX.acn();
            iX = this.bSX.iX(str2);
            hashMap = this.bSX.bSV;
            hashMap.put(acn, iX);
        }
        this.bSX.bSN = true;
    }
}
