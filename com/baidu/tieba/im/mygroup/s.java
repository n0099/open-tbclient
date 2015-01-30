package com.baidu.tieba.im.mygroup;
/* loaded from: classes.dex */
class s implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ m bkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.bkY = mVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        PersonGroupActivity RW = this.bkY.RW();
        if (RW != null) {
            RW.RS().update();
        }
    }
}
