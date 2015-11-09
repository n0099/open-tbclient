package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ MyGiftListActivity bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bnC = myGiftListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        boolean z;
        long j;
        l lVar;
        l lVar2;
        if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null) {
            z = this.bnC.mIsHost;
            if (!z) {
                j = this.bnC.mUserId;
                if (j == l.longValue()) {
                    lVar = this.bnC.bnw;
                    lVar.cC(false);
                    lVar2 = this.bnC.bnw;
                    lVar2.LoadData();
                }
            }
        }
    }
}
