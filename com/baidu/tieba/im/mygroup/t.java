package com.baidu.tieba.im.mygroup;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ n bgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(n nVar) {
        this.bgm = nVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        PersonGroupActivity Ra;
        Ra = this.bgm.Ra();
        if (Ra != null) {
            Ra.QW().update();
        }
    }
}
