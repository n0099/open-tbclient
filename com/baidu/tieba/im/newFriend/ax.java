package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.im.g<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity blB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewFriendsActivity newFriendsActivity) {
        this.blB = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: aC */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        az azVar;
        az azVar2;
        azVar = this.blB.blv;
        azVar.jI();
        azVar2 = this.blB.blv;
        azVar2.setData(list);
    }
}
