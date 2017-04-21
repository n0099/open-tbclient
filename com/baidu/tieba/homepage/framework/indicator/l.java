package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ScrollFragmentTabHost cxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cxk.topHeight = i2;
        aVar = this.cxk.cwY;
        if (aVar != null) {
            aVar2 = this.cxk.cwY;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cxk.cxb;
        if (rVar != null) {
            rVar2 = this.cxk.cxb;
            rVar2.jQ(i2);
        }
    }
}
