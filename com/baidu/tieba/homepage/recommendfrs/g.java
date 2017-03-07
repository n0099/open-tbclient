package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends s<Object> {
    private final /* synthetic */ int aay;
    final /* synthetic */ b cBs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.cBs = bVar;
        this.aay = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a aVar = com.baidu.tbadk.core.c.a.to();
        str = this.cBs.cvY;
        o<String> L = aVar.L(str, TbadkCoreApplication.getCurrentAccount());
        if (L != null) {
            str2 = this.cBs.cvZ;
            L.a(str2, Integer.toString(this.aay), 43200000L);
            return null;
        }
        return null;
    }
}
