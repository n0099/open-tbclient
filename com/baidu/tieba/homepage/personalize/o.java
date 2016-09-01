package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ int VV;
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar, int i) {
        this.this$0 = bVar;
        this.VV = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sT = com.baidu.tbadk.core.b.a.sT();
        str = this.this$0.cEZ;
        com.baidu.adp.lib.cache.o<String> N = sT.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cEZ;
            N.a(str2, Integer.toString(this.VV), 43200000L);
            return null;
        }
        return null;
    }
}
