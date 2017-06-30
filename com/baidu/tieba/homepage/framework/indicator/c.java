package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends w<String> {
    final /* synthetic */ a cHN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cHN = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: amm */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sW = com.baidu.tbadk.core.c.a.sW();
        str = this.cHN.cHF;
        o<String> M = sW.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cHN.cHG;
            return M.get(str2);
        }
        return null;
    }
}
