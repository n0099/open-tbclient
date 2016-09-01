package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.homepage.framework.x {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cCF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.x
    public void jO(int i) {
        y yVar;
        com.baidu.tieba.homepage.framework.y yVar2;
        yVar = this.cCF.cCC;
        yVar2 = this.cCF.cCD;
        yVar.a(i, yVar2);
    }
}
