package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements com.baidu.tieba.im.a<List<com.baidu.tieba.im.data.e>> {
    final /* synthetic */ NewFriendsActivity bhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(NewFriendsActivity newFriendsActivity) {
        this.bhm = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: ac */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.e> list) {
        az azVar;
        az azVar2;
        azVar = this.bhm.bhg;
        azVar.Ro().setData(list);
        azVar2 = this.bhm.bhg;
        azVar2.Ro().notifyDataSetChanged();
    }
}
