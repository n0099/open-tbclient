package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ScrollFragmentTabHost cpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cpc = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        a aVar;
        m mVar;
        m mVar2;
        a aVar2;
        this.cpc.topHeight = i2;
        aVar = this.cpc.coT;
        if (aVar != null) {
            aVar2 = this.cpc.coT;
            aVar2.b(view, i, i2, i3, i4);
        }
        mVar = this.cpc.coW;
        if (mVar != null) {
            mVar2 = this.cpc.coW;
            mVar2.jm(i2);
        }
    }
}
