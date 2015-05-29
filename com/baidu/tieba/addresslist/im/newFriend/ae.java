package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* loaded from: classes.dex */
class ae implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ ac azZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.azZ = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(this.azZ.num, false));
    }
}
