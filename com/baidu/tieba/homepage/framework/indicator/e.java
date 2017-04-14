package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int aaO;
    final /* synthetic */ a cuE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cuE = aVar;
        this.aaO = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a tM = com.baidu.tbadk.core.c.a.tM();
        str = this.cuE.cuy;
        com.baidu.adp.lib.cache.o<String> M = tM.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cuE.cuz;
            M.a(str2, Integer.toString(this.aaO), 43200000L);
            return null;
        }
        return null;
    }
}
