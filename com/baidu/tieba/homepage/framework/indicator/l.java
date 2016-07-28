package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost crx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.crx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.crx.topHeight = i2;
        aVar = this.crx.crl;
        if (aVar != null) {
            aVar2 = this.crx.crl;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.crx.cro;
        if (rVar != null) {
            rVar2 = this.crx.cro;
            rVar2.jr(i2);
        }
    }
}
