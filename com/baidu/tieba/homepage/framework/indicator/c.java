package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends v<String> {
    final /* synthetic */ a ctJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ctJ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: ahm */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sZ = com.baidu.tbadk.core.c.a.sZ();
        str = this.ctJ.ctB;
        o<String> M = sZ.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.ctJ.ctC;
            return M.get(str2);
        }
        return null;
    }
}
