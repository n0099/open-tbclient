package com.baidu.tbadk.live;

import com.baidu.adp.lib.cache.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements u<String> {
    final /* synthetic */ a Vs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.Vs = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: Y */
    public void d(String str, String str2) {
        if (str2 != null) {
            this.Vs.X(str, str2);
        } else {
            this.Vs.dA(str);
        }
    }
}
