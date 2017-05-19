package com.baidu.tieba.homepage.personalize;

import com.baidu.tieba.frs.ch;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements ScrollFragmentTabHost.a {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(o oVar) {
        this.this$0 = oVar;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
    public void jL(int i) {
        ch chVar;
        ch chVar2;
        if (i > 0) {
            chVar = this.this$0.cuM;
            if (chVar != null) {
                chVar2 = this.this$0.cuM;
                chVar2.hideTip();
            }
        }
    }
}
