package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cCF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cCF.topHeight = i2;
        aVar = this.cCF.cCt;
        if (aVar != null) {
            aVar2 = this.cCF.cCt;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cCF.cCw;
        if (rVar != null) {
            rVar2 = this.cCF.cCw;
            rVar2.jT(i2);
        }
    }
}
