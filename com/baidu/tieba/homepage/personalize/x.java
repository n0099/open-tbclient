package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int WD;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(n nVar, int i) {
        this.this$0 = nVar;
        this.WD = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a tm = com.baidu.tbadk.core.b.a.tm();
        str = this.this$0.cLi;
        com.baidu.adp.lib.cache.o<String> N = tm.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cLi;
            N.a(str2, Integer.toString(this.WD), 43200000L);
            return null;
        }
        return null;
    }
}
