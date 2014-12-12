package com.baidu.tieba.im.mygroup;
/* loaded from: classes.dex */
class s implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ m bjB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.bjB = mVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonGroupActivity RA = this.bjB.RA();
        if (RA != null) {
            RA.Rw().update();
        }
    }
}
