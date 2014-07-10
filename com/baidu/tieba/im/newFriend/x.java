package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ NewFriendDbManagerStatic a;
    private final /* synthetic */ com.baidu.tieba.im.data.k b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.k kVar, String str, String str2) {
        this.a = newFriendDbManagerStatic;
        this.b = kVar;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.b.a(), this.b.c(), this.b.b(), this.c, this.d));
    }
}
