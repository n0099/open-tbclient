package com.baidu.tieba.homepage.personalize;

import com.baidu.tieba.frs.ci;
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
    public void kk(int i) {
        ci ciVar;
        ci ciVar2;
        if (i > 0) {
            ciVar = this.this$0.cBe;
            if (ciVar != null) {
                ciVar2 = this.this$0.cBe;
                ciVar2.hideTip();
            }
        }
    }
}
