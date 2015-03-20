package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class s implements ae {
    final /* synthetic */ m blM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.blM = mVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        PersonGroupActivity SW = this.blM.SW();
        if (SW != null) {
            SW.SS().update();
        }
    }
}
