package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends s<String> {
    final /* synthetic */ b czW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.czW = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ajC */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sR = com.baidu.tbadk.core.c.a.sR();
        str = this.czW.cuz;
        o<String> N = sR.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.czW.cuA;
            return N.get(str2);
        }
        return null;
    }
}
