package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bkZ;
    private final /* synthetic */ com.baidu.tieba.im.data.b bla;
    private final /* synthetic */ String blb;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar, String str, String str2) {
        this.bkZ = newFriendDbManagerStatic;
        this.bla = bVar;
        this.val$key = str;
        this.blb = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.bla.getId(), this.bla.getPortrait(), this.bla.getName(), this.val$key, this.blb));
    }
}
