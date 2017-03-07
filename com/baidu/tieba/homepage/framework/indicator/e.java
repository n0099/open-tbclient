package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int aay;
    final /* synthetic */ a cwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cwe = aVar;
        this.aay = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a aVar = com.baidu.tbadk.core.c.a.to();
        str = this.cwe.cvY;
        com.baidu.adp.lib.cache.o<String> L = aVar.L(str, TbadkCoreApplication.getCurrentAccount());
        if (L != null) {
            str2 = this.cwe.cvZ;
            L.a(str2, Integer.toString(this.aay), 43200000L);
            return null;
        }
        return null;
    }
}
