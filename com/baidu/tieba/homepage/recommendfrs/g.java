package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends s<Object> {
    private final /* synthetic */ int WD;
    final /* synthetic */ b cNN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, int i) {
        this.cNN = bVar;
        this.WD = i;
    }

    @Override // com.baidu.tbadk.util.s
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a tm = com.baidu.tbadk.core.b.a.tm();
        str = this.cNN.cIc;
        o<String> N = tm.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cNN.cId;
            N.a(str2, Integer.toString(this.WD), 43200000L);
            return null;
        }
        return null;
    }
}
