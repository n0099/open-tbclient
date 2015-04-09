package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.g<Void> {
    final /* synthetic */ NewFriendDbManagerStatic ayc;
    private final /* synthetic */ long ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.ayc = newFriendDbManagerStatic;
        this.ayf = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: d */
    public void onReturnDataInUI(Void r9) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.ayf, "", "", "", ""));
    }
}
