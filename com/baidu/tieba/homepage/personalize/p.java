package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tbadk.util.t<String> {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(b bVar) {
        this.ctz = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: agZ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a rO = com.baidu.tbadk.core.b.a.rO();
        str = this.ctz.ctt;
        com.baidu.adp.lib.cache.o<String> N = rO.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.ctz.ctt;
            return N.get(str2);
        }
        return null;
    }
}
