package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ ab bgU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.bgU = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r3) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(this.bgU.num));
    }
}
