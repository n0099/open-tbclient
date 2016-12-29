package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends s<Object> {
    private final /* synthetic */ int VX;
    final /* synthetic */ b csS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.csS = bVar;
        this.VX = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sX = com.baidu.tbadk.core.b.a.sX();
        str = this.csS.cnx;
        o<String> N = sX.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.csS.cny;
            N.a(str2, Integer.toString(this.VX), 43200000L);
            return null;
        }
        return null;
    }
}
