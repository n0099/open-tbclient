package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int Vn;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(n nVar, int i) {
        this.this$0 = nVar;
        this.Vn = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sR = com.baidu.tbadk.core.c.a.sR();
        str = this.this$0.cxE;
        com.baidu.adp.lib.cache.o<String> N = sR.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cxE;
            N.a(str2, Integer.toString(this.Vn), 43200000L);
            return null;
        }
        return null;
    }
}
