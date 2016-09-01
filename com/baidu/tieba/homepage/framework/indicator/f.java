package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.t<String> {
    final /* synthetic */ a cCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cCq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: alK */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sT = com.baidu.tbadk.core.b.a.sT();
        str = this.cCq.cCk;
        com.baidu.adp.lib.cache.o<String> N = sT.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cCq.cCl;
            return N.get(str2);
        }
        return null;
    }
}
