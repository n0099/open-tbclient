package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ a cIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cIi = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: anU */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a tm = com.baidu.tbadk.core.b.a.tm();
        str = this.cIi.cIc;
        com.baidu.adp.lib.cache.o<String> N = tm.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.cIi.cId;
            return N.get(str2);
        }
        return null;
    }
}
