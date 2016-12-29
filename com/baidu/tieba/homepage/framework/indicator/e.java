package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int VX;
    final /* synthetic */ a cnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cnD = aVar;
        this.VX = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sX = com.baidu.tbadk.core.b.a.sX();
        str = this.cnD.cnx;
        com.baidu.adp.lib.cache.o<String> N = sX.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cnD.cny;
            N.a(str2, Integer.toString(this.VX), 43200000L);
            return null;
        }
        return null;
    }
}
