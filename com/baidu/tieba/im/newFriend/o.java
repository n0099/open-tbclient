package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ k a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, long j) {
        this.a = kVar;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.b, "", "", "", ""));
    }
}
