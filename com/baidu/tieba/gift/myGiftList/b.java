package com.baidu.tieba.gift.myGiftList;

import com.baidu.tieba.gift.myGiftList.j;
/* loaded from: classes.dex */
class b implements j.a {
    final /* synthetic */ MyGiftListActivity bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MyGiftListActivity myGiftListActivity) {
        this.bwy = myGiftListActivity;
    }

    @Override // com.baidu.tieba.gift.myGiftList.j.a
    public void a(int i, String str, boolean z, a aVar) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        this.bwy.closeLoadingDialog();
        lVar = this.bwy.bws;
        lVar.getFooterView().setVisibility(8);
        lVar2 = this.bwy.bws;
        lVar2.Tx();
        if (i == 0) {
            lVar3 = this.bwy.bws;
            lVar3.b(aVar);
            return;
        }
        this.bwy.showToast(str);
        if (z) {
            lVar4 = this.bwy.bws;
            lVar4.b(aVar);
        }
    }
}
