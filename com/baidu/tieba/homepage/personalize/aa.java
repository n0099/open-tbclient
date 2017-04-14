package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.util.s<String> {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(n nVar) {
        this.this$0 = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aiJ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a tM = com.baidu.tbadk.core.c.a.tM();
        str = this.this$0.cxB;
        com.baidu.adp.lib.cache.o<String> M = tM.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.this$0.cxB;
            return M.get(str2);
        }
        return null;
    }
}
