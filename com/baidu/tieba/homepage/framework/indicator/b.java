package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends w<Object> {
    private final /* synthetic */ int aak;
    final /* synthetic */ a cHN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.cHN = aVar;
        this.aak = i;
    }

    @Override // com.baidu.tbadk.util.w
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sW = com.baidu.tbadk.core.c.a.sW();
        str = this.cHN.cHF;
        o<String> M = sW.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cHN.cHG;
            M.a(str2, Integer.toString(this.aak), 43200000L);
            return null;
        }
        return null;
    }
}
