package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.homepage.framework.x {
    final /* synthetic */ ScrollFragmentTabHost cIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.x
    public void kb(int i) {
        y yVar;
        com.baidu.tieba.homepage.framework.y yVar2;
        yVar = this.cIx.cIu;
        yVar2 = this.cIx.cIv;
        yVar.a(i, yVar2);
    }
}
