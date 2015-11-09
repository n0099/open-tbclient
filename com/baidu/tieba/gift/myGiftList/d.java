package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class d implements NoNetworkView.a {
    final /* synthetic */ MyGiftListActivity bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MyGiftListActivity myGiftListActivity) {
        this.bnC = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        l lVar;
        l lVar2;
        if (z) {
            lVar = this.bnC.bnw;
            lVar.cC(false);
            lVar2 = this.bnC.bnw;
            lVar2.LoadData();
        }
    }
}
