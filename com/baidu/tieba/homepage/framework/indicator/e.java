package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ int Wf;
    final /* synthetic */ a cCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.cCV = aVar;
        this.Wf = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a ti = com.baidu.tbadk.core.b.a.ti();
        str = this.cCV.cCP;
        com.baidu.adp.lib.cache.o<String> N = ti.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cCV.cCQ;
            N.a(str2, Integer.toString(this.Wf), 43200000L);
            return null;
        }
        return null;
    }
}
