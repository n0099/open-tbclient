package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.util.w<String> {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(x xVar) {
        this.this$0 = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: amm */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.c.a sW = com.baidu.tbadk.core.c.a.sW();
        str = this.this$0.cJr;
        com.baidu.adp.lib.cache.o<String> M = sW.M(str, TbadkCoreApplication.getCurrentAccount());
        if (M != null) {
            str2 = this.this$0.cJr;
            return M.get(str2);
        }
        return null;
    }
}
