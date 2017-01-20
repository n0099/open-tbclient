package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int Vn;
    final /* synthetic */ a cuF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cuF = aVar;
        this.Vn = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sR = com.baidu.tbadk.core.c.a.sR();
        str = this.cuF.cuz;
        com.baidu.adp.lib.cache.o<String> N = sR.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cuF.cuA;
            N.a(str2, Integer.toString(this.Vn), 43200000L);
            return null;
        }
        return null;
    }
}
