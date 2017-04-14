package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ScrollFragmentTabHost cuT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuT = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cuT.topHeight = i2;
        aVar = this.cuT.cuH;
        if (aVar != null) {
            aVar2 = this.cuT.cuH;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cuT.cuK;
        if (rVar != null) {
            rVar2 = this.cuT.cuK;
            rVar2.jK(i2);
        }
    }
}
