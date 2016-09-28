package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.util.t<String> {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(m mVar) {
        this.this$0 = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: alZ */
    public String doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a ti = com.baidu.tbadk.core.b.a.ti();
        str = this.this$0.cFX;
        com.baidu.adp.lib.cache.o<String> N = ti.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cFX;
            return N.get(str2);
        }
        return null;
    }
}
