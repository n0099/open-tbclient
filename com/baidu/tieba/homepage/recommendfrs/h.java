package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends s<String> {
    final /* synthetic */ b cBs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.cBs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aiP */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a aVar = com.baidu.tbadk.core.c.a.to();
        str = this.cBs.cvY;
        o<String> L = aVar.L(str, TbadkCoreApplication.getCurrentAccount());
        if (L != null) {
            str2 = this.cBs.cvZ;
            return L.get(str2);
        }
        return null;
    }
}
