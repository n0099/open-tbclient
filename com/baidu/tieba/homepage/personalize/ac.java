package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.tbadk.util.v<Object> {
    private final /* synthetic */ int aaj;
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(o oVar, int i) {
        this.this$0 = oVar;
        this.aaj = i;
    }

    @Override // com.baidu.tbadk.util.v
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sY = com.baidu.tbadk.core.c.a.sY();
        str = this.this$0.cBu;
        com.baidu.adp.lib.cache.o<String> M = sY.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.this$0.cBu;
            M.a(str2, Integer.toString(this.aaj), 43200000L);
            return null;
        }
        return null;
    }
}
