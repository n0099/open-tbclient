package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.t<String> {
    final /* synthetic */ a cCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cCV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: alZ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a ti = com.baidu.tbadk.core.b.a.ti();
        str = this.cCV.cCP;
        com.baidu.adp.lib.cache.o<String> N = ti.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cCV.cCQ;
            return N.get(str2);
        }
        return null;
    }
}
