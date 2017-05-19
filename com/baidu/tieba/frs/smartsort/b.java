package com.baidu.tieba.frs.smartsort;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements o.a<String> {
    final /* synthetic */ a bYI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYI = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aO */
    public void m(String str, String str2) {
        ArrayList jb;
        HashMap hashMap;
        if (str2 != null) {
            jb = this.bYI.jb(str2);
            String aci = this.bYI.aci();
            hashMap = this.bYI.bYG;
            hashMap.put(aci, jb);
        }
        this.bYI.bYF = true;
    }
}
