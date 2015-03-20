package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic axU;
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;
    private final /* synthetic */ String axW;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar, String str, String str2) {
        this.axU = newFriendDbManagerStatic;
        this.axV = bVar;
        this.val$key = str;
        this.axW = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.axV.getId(), this.axV.getPortrait(), this.axV.getName(), this.val$key, this.axW));
    }
}
