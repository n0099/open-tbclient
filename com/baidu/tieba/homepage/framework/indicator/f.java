package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ a cuF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cuF = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ajC */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sR = com.baidu.tbadk.core.c.a.sR();
        str = this.cuF.cuz;
        com.baidu.adp.lib.cache.o<String> N = sR.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cuF.cuA;
            return N.get(str2);
        }
        return null;
    }
}
