package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends t<String> {
    final /* synthetic */ b cIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.cIy = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: alZ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a ti = com.baidu.tbadk.core.b.a.ti();
        str = this.cIy.cCP;
        o<String> N = ti.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cIy.cCQ;
            return N.get(str2);
        }
        return null;
    }
}
