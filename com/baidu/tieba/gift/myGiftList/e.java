package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ MyGiftListActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bmY = myGiftListActivity;
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
            z = this.bmY.mIsHost;
            if (!z) {
                j = this.bmY.mUserId;
                if (j == l.longValue()) {
                    lVar = this.bmY.bmS;
                    lVar.cA(false);
                    lVar2 = this.bmY.bmS;
                    lVar2.LoadData();
                }
            }
        }
    }
}
