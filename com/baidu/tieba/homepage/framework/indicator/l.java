package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cIx.topHeight = i2;
        aVar = this.cIx.cIl;
        if (aVar != null) {
            aVar2 = this.cIx.cIl;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cIx.cIo;
        if (rVar != null) {
            rVar2 = this.cIx.cIo;
            rVar2.kg(i2);
        }
    }
}
