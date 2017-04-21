package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ a cwV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cwV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ajK */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a tM = com.baidu.tbadk.core.c.a.tM();
        str = this.cwV.cwP;
        com.baidu.adp.lib.cache.o<String> M = tM.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.cwV.cwQ;
            return M.get(str2);
        }
        return null;
    }
}
