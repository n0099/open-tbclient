package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends t<Object> {
    private final /* synthetic */ int VV;
    final /* synthetic */ b cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.cHG = bVar;
        this.VV = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sT = com.baidu.tbadk.core.b.a.sT();
        str = this.cHG.cCk;
        o<String> N = sT.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cHG.cCl;
            N.a(str2, Integer.toString(this.VV), 43200000L);
            return null;
        }
        return null;
    }
}
