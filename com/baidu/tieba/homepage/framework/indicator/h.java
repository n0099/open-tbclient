package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ ScrollFragmentTabHost cAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cAs = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        a aVar2;
        aVar = this.cAs.cAm;
        if (aVar != null) {
            aVar2 = this.cAs.cAm;
            aVar2.b(view, i, i2, i3, i4);
        }
    }
}
