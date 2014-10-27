package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tieba.im.a<List<com.baidu.tieba.im.data.e>> {
    final /* synthetic */ NewFriendsActivity bgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewFriendsActivity newFriendsActivity) {
        this.bgY = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: ac */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.e> list) {
        az azVar;
        azVar = this.bgY.bgS;
        azVar.ab(list);
    }
}
