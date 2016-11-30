package com.baidu.tieba.frs.g;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a cgT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cgT = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aC */
    public void m(String str, String str2) {
        ArrayList kg;
        HashMap hashMap;
        if (str2 == null) {
            return;
        }
        kg = this.cgT.kg(str2);
        String agK = this.cgT.agK();
        hashMap = this.cgT.cgR;
        hashMap.put(agK, kg);
        this.cgT.cgQ = true;
    }
}
