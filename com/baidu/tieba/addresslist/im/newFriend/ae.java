package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* loaded from: classes.dex */
class ae implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ ac aID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.aID = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r4) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(this.aID.num, false));
    }
}
