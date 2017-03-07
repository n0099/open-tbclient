package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int aay;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(n nVar, int i) {
        this.this$0 = nVar;
        this.aay = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a aVar = com.baidu.tbadk.core.c.a.to();
        str = this.this$0.czb;
        com.baidu.adp.lib.cache.o<String> L = aVar.L(str, TbadkCoreApplication.getCurrentAccount());
        if (L != null) {
            str2 = this.this$0.czb;
            L.a(str2, Integer.toString(this.aay), 43200000L);
            return null;
        }
        return null;
    }
}
