package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.homepage.framework.x {
    final /* synthetic */ ScrollFragmentTabHost crx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.crx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.x
    public void jm(int i) {
        y yVar;
        com.baidu.tieba.homepage.framework.y yVar2;
        yVar = this.crx.cru;
        yVar2 = this.crx.crv;
        yVar.a(i, yVar2);
    }
}
