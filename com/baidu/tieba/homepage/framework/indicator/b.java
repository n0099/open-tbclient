package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends v<Object> {
    private final /* synthetic */ int aaj;
    final /* synthetic */ a cAb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.cAb = aVar;
        this.aaj = i;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sY = com.baidu.tbadk.core.c.a.sY();
        str = this.cAb.czT;
        o<String> M = sY.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cAb.czU;
            M.a(str2, Integer.toString(this.aaj), 43200000L);
            return null;
        }
        return null;
    }
}
