package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cuU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuU = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cuU.topHeight = i2;
        aVar = this.cuU.cuI;
        if (aVar != null) {
            aVar2 = this.cuU.cuI;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cuU.cuL;
        if (rVar != null) {
            rVar2 = this.cuU.cuL;
            rVar2.ke(i2);
        }
    }
}
