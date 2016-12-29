package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends s<String> {
    final /* synthetic */ b csS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.csS = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aiu */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sX = com.baidu.tbadk.core.b.a.sX();
        str = this.csS.cnx;
        o<String> N = sX.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.csS.cny;
            return N.get(str2);
        }
        return null;
    }
}
