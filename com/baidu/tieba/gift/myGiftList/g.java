package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class g implements BdListView.e {
    final /* synthetic */ MyGiftListActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyGiftListActivity myGiftListActivity) {
        this.bmY = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        l lVar;
        m mVar;
        l lVar2;
        l lVar3;
        m mVar2;
        lVar = this.bmY.bmS;
        if (lVar.isHasMore()) {
            lVar2 = this.bmY.bmS;
            lVar2.cA(true);
            lVar3 = this.bmY.bmS;
            lVar3.LoadData();
            mVar2 = this.bmY.bmT;
            mVar2.getFooterView().setVisibility(0);
            return;
        }
        mVar = this.bmY.bmT;
        mVar.getFooterView().setVisibility(8);
    }
}
