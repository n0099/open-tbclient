package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class e implements BdListView.e {
    final /* synthetic */ MyGiftListActivity bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyGiftListActivity myGiftListActivity) {
        this.bwy = myGiftListActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        j jVar;
        l lVar;
        j jVar2;
        j jVar3;
        l lVar2;
        jVar = this.bwy.bwr;
        if (jVar.isHasMore()) {
            jVar2 = this.bwy.bwr;
            jVar2.cV(true);
            jVar3 = this.bwy.bwr;
            jVar3.LoadData();
            lVar2 = this.bwy.bws;
            lVar2.getFooterView().setVisibility(0);
            return;
        }
        lVar = this.bwy.bws;
        lVar.getFooterView().setVisibility(8);
    }
}
