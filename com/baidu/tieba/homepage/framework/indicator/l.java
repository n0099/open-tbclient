package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cDk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cDk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cDk.topHeight = i2;
        aVar = this.cDk.cCY;
        if (aVar != null) {
            aVar2 = this.cDk.cCY;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cDk.cDb;
        if (rVar != null) {
            rVar2 = this.cDk.cDb;
            rVar2.jZ(i2);
        }
    }
}
