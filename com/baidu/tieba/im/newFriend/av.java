package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements com.baidu.tieba.im.g<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity bke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewFriendsActivity newFriendsActivity) {
        this.bke = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: az */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        az azVar;
        az azVar2;
        azVar = this.bke.bjY;
        azVar.RI().setData(list);
        azVar2 = this.bke.bjY;
        azVar2.RI().notifyDataSetChanged();
    }
}
