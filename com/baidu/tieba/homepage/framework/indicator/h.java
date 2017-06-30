package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ScrollFragmentTabHost cIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIe = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        a aVar2;
        aVar = this.cIe.cHY;
        if (aVar != null) {
            aVar2 = this.cIe.cHY;
            aVar2.b(view, i, i2, i3, i4);
        }
    }
}
