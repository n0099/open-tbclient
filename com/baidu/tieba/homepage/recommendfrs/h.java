package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends s<String> {
    final /* synthetic */ b cNN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.cNN = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: anU */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a tm = com.baidu.tbadk.core.b.a.tm();
        str = this.cNN.cIc;
        o<String> N = tm.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cNN.cId;
            return N.get(str2);
        }
        return null;
    }
}
