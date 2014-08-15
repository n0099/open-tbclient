package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ s a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ String f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar, long j, String str, String str2, String str3, String str4) {
        this.a = sVar;
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.b, this.c, this.d, this.e, this.f));
    }
}
