package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements p.a {
    final /* synthetic */ MyGiftListActivity bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MyGiftListActivity myGiftListActivity) {
        this.bnC = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        m mVar;
        l lVar;
        l lVar2;
        if (!com.baidu.adp.lib.util.k.je()) {
            mVar = this.bnC.bnx;
            mVar.QS();
            return;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().xd();
        lVar = this.bnC.bnw;
        lVar.cC(false);
        lVar2 = this.bnC.bnw;
        lVar2.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bnC.bnz);
    }
}
