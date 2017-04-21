package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends s<String> {
    final /* synthetic */ b cCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.cCi = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ajK */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a tM = com.baidu.tbadk.core.c.a.tM();
        str = this.cCi.cwP;
        o<String> M = tM.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cCi.cwQ;
            return M.get(str2);
        }
        return null;
    }
}
