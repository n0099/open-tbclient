package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.util.t<Object> {
    private final /* synthetic */ int Wf;
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(m mVar, int i) {
        this.this$0 = mVar;
        this.Wf = i;
    }

    @Override // com.baidu.tbadk.util.t
    public Object doInBackground() {
        String str;
        String str2;
        com.baidu.tbadk.core.b.a ti = com.baidu.tbadk.core.b.a.ti();
        str = this.this$0.cFX;
        com.baidu.adp.lib.cache.o<String> N = ti.N(str, TbadkCoreApplication.getCurrentAccount());
        if (N != null) {
            str2 = this.this$0.cFX;
            N.a(str2, Integer.toString(this.Wf), 43200000L);
            return null;
        }
        return null;
    }
}
