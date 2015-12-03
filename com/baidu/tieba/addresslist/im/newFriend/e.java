package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.util.d<Void> {
    final /* synthetic */ NewFriendDbManagerStatic aIr;
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;
    private final /* synthetic */ String aIt;
    private final /* synthetic */ String tA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.b bVar, String str, String str2) {
        this.aIr = newFriendDbManagerStatic;
        this.aIs = bVar;
        this.tA = str;
        this.aIt = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.aIs.getId(), this.aIs.getPortrait(), this.aIs.getName(), this.tA, this.aIt));
    }
}
