package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.util.t<String> {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(b bVar) {
        this.this$0 = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: alK */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sT = com.baidu.tbadk.core.b.a.sT();
        str = this.this$0.cEZ;
        com.baidu.adp.lib.cache.o<String> N = sT.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cEZ;
            return N.get(str2);
        }
        return null;
    }
}
