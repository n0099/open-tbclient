package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.s<Object> {
    private final /* synthetic */ int WD;
    final /* synthetic */ a cIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cIi = aVar;
        this.WD = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a tm = com.baidu.tbadk.core.b.a.tm();
        str = this.cIi.cIc;
        com.baidu.adp.lib.cache.o<String> N = tm.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cIi.cId;
            N.a(str2, Integer.toString(this.WD), 43200000L);
            return null;
        }
        return null;
    }
}
