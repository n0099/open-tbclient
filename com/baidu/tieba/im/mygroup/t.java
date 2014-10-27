package com.baidu.tieba.im.mygroup;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ n bfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(n nVar) {
        this.bfY = nVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        PersonGroupActivity QX;
        QX = this.bfY.QX();
        if (QX != null) {
            QX.QT().update();
        }
    }
}
