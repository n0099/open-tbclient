package com.baidu.tieba.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bgL;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;
    private final /* synthetic */ String bgN;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.e eVar, String str, String str2) {
        this.bgL = newFriendDbManagerStatic;
        this.bgM = eVar;
        this.fR = str;
        this.bgN = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: b */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.bgM.getId(), this.bgM.getPortrait(), this.bgM.getName(), this.fR, this.bgN));
    }
}
