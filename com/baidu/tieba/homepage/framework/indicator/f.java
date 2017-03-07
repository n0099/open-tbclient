package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ a cwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cwe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aiP */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a aVar = com.baidu.tbadk.core.c.a.to();
        str = this.cwe.cvY;
        com.baidu.adp.lib.cache.o<String> L = aVar.L(str, TbadkCoreApplication.getCurrentAccount());
        if (L != null) {
            str2 = this.cwe.cvZ;
            return L.get(str2);
        }
        return null;
    }
}
