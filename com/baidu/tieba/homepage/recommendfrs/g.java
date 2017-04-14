package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends s<Object> {
    private final /* synthetic */ int aaO;
    final /* synthetic */ b czR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.czR = bVar;
        this.aaO = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a tM = com.baidu.tbadk.core.c.a.tM();
        str = this.czR.cuy;
        o<String> M = tM.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.czR.cuz;
            M.a(str2, Integer.toString(this.aaO), 43200000L);
            return null;
        }
        return null;
    }
}
