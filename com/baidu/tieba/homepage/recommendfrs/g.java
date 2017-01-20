package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends s<Object> {
    private final /* synthetic */ int Vn;
    final /* synthetic */ b czW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.czW = bVar;
        this.Vn = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sR = com.baidu.tbadk.core.c.a.sR();
        str = this.czW.cuz;
        o<String> N = sR.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.czW.cuA;
            N.a(str2, Integer.toString(this.Vn), 43200000L);
            return null;
        }
        return null;
    }
}
