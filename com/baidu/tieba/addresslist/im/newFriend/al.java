package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.util.d<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewFriendsActivity newFriendsActivity) {
        this.aIX = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: y */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        ax axVar;
        axVar = this.aIX.aIQ;
        axVar.x(list);
    }
}
