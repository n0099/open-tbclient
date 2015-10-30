package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements p.a {
    final /* synthetic */ MyGiftListActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MyGiftListActivity myGiftListActivity) {
        this.bmY = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        m mVar;
        l lVar;
        l lVar2;
        if (!com.baidu.adp.lib.util.k.jd()) {
            mVar = this.bmY.bmT;
            mVar.Qw();
            return;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.wH().wY();
        lVar = this.bmY.bmS;
        lVar.cA(false);
        lVar2 = this.bmY.bmS;
        lVar2.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bmY.bmV);
    }
}
