package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.tbadk.util.w<Object> {
    private final /* synthetic */ int aak;
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(x xVar, int i) {
        this.this$0 = xVar;
        this.aak = i;
    }

    @Override // com.baidu.tbadk.util.w
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sW = com.baidu.tbadk.core.c.a.sW();
        str = this.this$0.cJr;
        com.baidu.adp.lib.cache.o<String> M = sW.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.this$0.cJr;
            M.a(str2, Integer.toString(this.aak), 43200000L);
            return null;
        }
        return null;
    }
}
