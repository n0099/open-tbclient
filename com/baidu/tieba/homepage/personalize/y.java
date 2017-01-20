package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(n nVar) {
        this.this$0 = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ajC */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sR = com.baidu.tbadk.core.c.a.sR();
        str = this.this$0.cxE;
        com.baidu.adp.lib.cache.o<String> N = sR.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cxE;
            return N.get(str2);
        }
        return null;
    }
}
