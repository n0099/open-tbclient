package com.baidu.tieba.homepage.personalize;

import com.baidu.tieba.frs.cj;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ScrollFragmentTabHost.a {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar) {
        this.this$0 = xVar;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.a
    public void kv(int i) {
        cj cjVar;
        cj cjVar2;
        if (i > 0) {
            cjVar = this.this$0.cJa;
            if (cjVar != null) {
                cjVar2 = this.this$0.cJa;
                cjVar2.hideTip();
            }
        }
    }
}
