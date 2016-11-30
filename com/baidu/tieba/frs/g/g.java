package com.baidu.tieba.frs.g;

import com.baidu.adp.lib.cache.o;
import java.util.ArrayList;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements o.a<String> {
    final /* synthetic */ f cha;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.cha = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.o.a
    /* renamed from: aC */
    public void m(String str, String str2) {
        ArrayList kg;
        HashMap hashMap;
        if (str2 != null) {
            String agK = this.cha.agK();
            kg = this.cha.kg(str2);
            hashMap = this.cha.cgY;
            hashMap.put(agK, kg);
            this.cha.cgQ = true;
        }
    }
}
