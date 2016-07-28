package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ int Tf;
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar, int i) {
        this.ctz = bVar;
        this.Tf = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a rO = com.baidu.tbadk.core.b.a.rO();
        str = this.ctz.ctt;
        com.baidu.adp.lib.cache.o<String> N = rO.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.ctz.ctt;
            N.a(str2, Integer.toString(this.Tf), 43200000L);
            return null;
        }
        return null;
    }
}
