package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.t<String> {
    final /* synthetic */ a cri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cri = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: agZ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a rO = com.baidu.tbadk.core.b.a.rO();
        str = this.cri.crc;
        com.baidu.adp.lib.cache.o<String> N = rO.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cri.crd;
            return N.get(str2);
        }
        return null;
    }
}
