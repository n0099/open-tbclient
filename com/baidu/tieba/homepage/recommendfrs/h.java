package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends t<String> {
    final /* synthetic */ b cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.cHG = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: alK */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sT = com.baidu.tbadk.core.b.a.sT();
        str = this.cHG.cCk;
        o<String> N = sT.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cHG.cCl;
            return N.get(str2);
        }
        return null;
    }
}
