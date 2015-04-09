package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class s implements ae {
    final /* synthetic */ m bmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.bmc = mVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        PersonGroupActivity Tj = this.bmc.Tj();
        if (Tj != null) {
            Tj.Tf().update();
        }
    }
}
