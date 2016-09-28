package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends t<Object> {
    private final /* synthetic */ int Wf;
    final /* synthetic */ b cIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.cIy = bVar;
        this.Wf = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a ti = com.baidu.tbadk.core.b.a.ti();
        str = this.cIy.cCP;
        o<String> N = ti.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cIy.cCQ;
            N.a(str2, Integer.toString(this.Wf), 43200000L);
            return null;
        }
        return null;
    }
}
