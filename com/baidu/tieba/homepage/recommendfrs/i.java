package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends t<String> {
    final /* synthetic */ b cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.cwb = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: agZ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a rO = com.baidu.tbadk.core.b.a.rO();
        str = this.cwb.crc;
        o<String> N = rO.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cwb.crd;
            return N.get(str2);
        }
        return null;
    }
}
