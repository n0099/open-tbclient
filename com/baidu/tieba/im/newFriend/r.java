package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, long j) {
        this.a = pVar;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.b, "", "", "", ""));
    }
}
