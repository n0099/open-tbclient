package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements o.a<String> {
    final /* synthetic */ e bYP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bYP = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aO */
    public void m(String str, String str2) {
        ArrayList jb;
        HashMap hashMap;
        if (str2 != null) {
            String aci = this.bYP.aci();
            jb = this.bYP.jb(str2);
            hashMap = this.bYP.bYN;
            hashMap.put(aci, jb);
        }
        this.bYP.bYF = true;
    }
}
