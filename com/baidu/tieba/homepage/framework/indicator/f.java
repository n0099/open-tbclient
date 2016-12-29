package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ a cnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cnD = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aiu */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a sX = com.baidu.tbadk.core.b.a.sX();
        str = this.cnD.cnx;
        com.baidu.adp.lib.cache.o<String> N = sX.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cnD.cny;
            return N.get(str2);
        }
        return null;
    }
}
