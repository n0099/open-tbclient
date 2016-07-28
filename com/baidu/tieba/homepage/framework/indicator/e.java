package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ int Tf;
    final /* synthetic */ a cri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cri = aVar;
        this.Tf = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a rO = com.baidu.tbadk.core.b.a.rO();
        str = this.cri.crc;
        com.baidu.adp.lib.cache.o<String> N = rO.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cri.crd;
            N.a(str2, Integer.toString(this.Tf), 43200000L);
            return null;
        }
        return null;
    }
}
