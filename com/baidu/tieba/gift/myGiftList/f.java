package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements q.a {
    final /* synthetic */ MyGiftListActivity bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyGiftListActivity myGiftListActivity) {
        this.bwy = myGiftListActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        l lVar;
        j jVar;
        j jVar2;
        if (!com.baidu.adp.lib.util.k.jg()) {
            lVar = this.bwy.bws;
            lVar.Tx();
            return;
        }
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ya();
        jVar = this.bwy.bwr;
        jVar.cV(false);
        jVar2 = this.bwy.bwr;
        jVar2.LoadData();
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bwy.bwu);
    }
}
