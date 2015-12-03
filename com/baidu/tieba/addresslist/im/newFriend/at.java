package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements com.baidu.tbadk.util.d<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.aIX = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: y */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        ax axVar;
        ax axVar2;
        axVar = this.aIX.aIQ;
        axVar.Hw().setData(list);
        axVar2 = this.aIX.aIQ;
        axVar2.Hw().notifyDataSetChanged();
    }
}
