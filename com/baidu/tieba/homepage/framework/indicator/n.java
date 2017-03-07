package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.homepage.framework.x {
    final /* synthetic */ ScrollFragmentTabHost cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cwt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.x
    public void jE(int i) {
        y yVar;
        com.baidu.tieba.homepage.framework.y yVar2;
        yVar = this.cwt.cwq;
        yVar2 = this.cwt.cwr;
        yVar.a(i, yVar2);
    }
}
