package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bla;
    private final /* synthetic */ com.baidu.tieba.im.data.b blb;
    private final /* synthetic */ String blc;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar, String str, String str2) {
        this.bla = newFriendDbManagerStatic;
        this.blb = bVar;
        this.val$key = str;
        this.blc = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.blb.getId(), this.blb.getPortrait(), this.blb.getName(), this.val$key, this.blc));
    }
}
