package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class g implements BdListView.e {
    final /* synthetic */ MyGiftListActivity bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyGiftListActivity myGiftListActivity) {
        this.bnC = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        l lVar;
        m mVar;
        l lVar2;
        l lVar3;
        m mVar2;
        lVar = this.bnC.bnw;
        if (lVar.isHasMore()) {
            lVar2 = this.bnC.bnw;
            lVar2.cC(true);
            lVar3 = this.bnC.bnw;
            lVar3.LoadData();
            mVar2 = this.bnC.bnx;
            mVar2.getFooterView().setVisibility(0);
            return;
        }
        mVar = this.bnC.bnx;
        mVar.getFooterView().setVisibility(8);
    }
}
