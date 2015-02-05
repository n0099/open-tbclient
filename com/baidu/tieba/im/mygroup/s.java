package com.baidu.tieba.im.mygroup;
/* loaded from: classes.dex */
class s implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ m bkX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.bkX = mVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonGroupActivity RR = this.bkX.RR();
        if (RR != null) {
            RR.RN().update();
        }
    }
}
