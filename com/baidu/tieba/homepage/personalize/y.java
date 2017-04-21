package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int aaP;
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(n nVar, int i) {
        this.this$0 = nVar;
        this.aaP = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a tM = com.baidu.tbadk.core.c.a.tM();
        str = this.this$0.czS;
        com.baidu.adp.lib.cache.o<String> M = tM.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.this$0.czS;
            M.a(str2, Integer.toString(this.aaP), 43200000L);
            return null;
        }
        return null;
    }
}
