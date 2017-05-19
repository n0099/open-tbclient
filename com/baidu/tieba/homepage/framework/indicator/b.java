package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends v<Object> {
    private final /* synthetic */ int aak;
    final /* synthetic */ a ctJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.ctJ = aVar;
        this.aak = i;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sZ = com.baidu.tbadk.core.c.a.sZ();
        str = this.ctJ.ctB;
        o<String> M = sZ.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.ctJ.ctC;
            M.a(str2, Integer.toString(this.aak), 43200000L);
            return null;
        }
        return null;
    }
}
