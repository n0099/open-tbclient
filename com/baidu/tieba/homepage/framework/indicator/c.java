package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends v<String> {
    final /* synthetic */ a cAb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cAb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: aiB */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sY = com.baidu.tbadk.core.c.a.sY();
        str = this.cAb.czT;
        o<String> M = sY.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cAb.czU;
            return M.get(str2);
        }
        return null;
    }
}
