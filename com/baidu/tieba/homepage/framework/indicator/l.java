package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cnS = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        r rVar;
        r rVar2;
        a aVar2;
        this.cnS.topHeight = i2;
        aVar = this.cnS.cnG;
        if (aVar != null) {
            aVar2 = this.cnS.cnG;
            aVar2.b(view, i, i2, i3, i4);
        }
        rVar = this.cnS.cnJ;
        if (rVar != null) {
            rVar2 = this.cnS.cnJ;
            rVar2.jr(i2);
        }
    }
}
