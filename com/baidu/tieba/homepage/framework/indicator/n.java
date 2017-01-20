package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.homepage.framework.x {
    final /* synthetic */ ScrollFragmentTabHost cuU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuU = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.x
    public void jZ(int i) {
        y yVar;
        com.baidu.tieba.homepage.framework.y yVar2;
        yVar = this.cuU.cuR;
        yVar2 = this.cuU.cuS;
        yVar.a(i, yVar2);
    }
}
