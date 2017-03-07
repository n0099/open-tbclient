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
    /* renamed from: aiP */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a aVar = com.baidu.tbadk.core.c.a.to();
        str = this.this$0.czb;
        com.baidu.adp.lib.cache.o<String> L = aVar.L(str, TbadkCoreApplication.getCurrentAccount());
        if (L != null) {
            str2 = this.this$0.czb;
            return L.get(str2);
        }
        return null;
    }
}
