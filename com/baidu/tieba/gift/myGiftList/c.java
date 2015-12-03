package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class c implements NoNetworkView.a {
    final /* synthetic */ MyGiftListActivity bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MyGiftListActivity myGiftListActivity) {
        this.bwy = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        j jVar;
        j jVar2;
        if (z) {
            jVar = this.bwy.bwr;
            jVar.cV(false);
            jVar2 = this.bwy.bwr;
            jVar2.LoadData();
        }
    }
}
