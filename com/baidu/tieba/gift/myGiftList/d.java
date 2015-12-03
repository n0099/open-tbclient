package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ MyGiftListActivity bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MyGiftListActivity myGiftListActivity, int i) {
        super(i);
        this.bwy = myGiftListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        boolean z;
        long j;
        j jVar;
        j jVar2;
        if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null) {
            z = this.bwy.mIsHost;
            if (!z) {
                j = this.bwy.mUserId;
                if (j == l.longValue()) {
                    jVar = this.bwy.bwr;
                    jVar.cV(false);
                    jVar2 = this.bwy.bwr;
                    jVar2.LoadData();
                }
            }
        }
    }
}
