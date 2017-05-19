package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.tbadk.util.v<String> {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(o oVar) {
        this.this$0 = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: ahm */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sZ = com.baidu.tbadk.core.c.a.sZ();
        str = this.this$0.cvc;
        com.baidu.adp.lib.cache.o<String> M = sZ.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.this$0.cvc;
            return M.get(str2);
        }
        return null;
    }
}
