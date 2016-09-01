package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ int VV;
    final /* synthetic */ a cCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cCq = aVar;
        this.VV = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sT = com.baidu.tbadk.core.b.a.sT();
        str = this.cCq.cCk;
        com.baidu.adp.lib.cache.o<String> N = sT.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cCq.cCl;
            N.a(str2, Integer.toString(this.VV), 43200000L);
            return null;
        }
        return null;
    }
}
