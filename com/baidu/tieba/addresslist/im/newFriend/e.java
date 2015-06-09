package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azO;
    private final /* synthetic */ com.baidu.tieba.im.data.b azP;
    private final /* synthetic */ String azQ;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar, String str, String str2) {
        this.azO = newFriendDbManagerStatic;
        this.azP = bVar;
        this.val$key = str;
        this.azQ = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.azP.getId(), this.azP.getPortrait(), this.azP.getName(), this.val$key, this.azQ));
    }
}
