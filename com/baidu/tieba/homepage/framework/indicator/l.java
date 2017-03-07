package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cwt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cwt.topHeight = i2;
        aVar = this.cwt.cwh;
        if (aVar != null) {
            aVar2 = this.cwt.cwh;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cwt.cwk;
        if (rVar != null) {
            rVar2 = this.cwt.cwk;
            rVar2.jJ(i2);
        }
    }
}
