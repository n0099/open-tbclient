package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ ab bjM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.bjM = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(this.bjM.num, false));
    }
}
