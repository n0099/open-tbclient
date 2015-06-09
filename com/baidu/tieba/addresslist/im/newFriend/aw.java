package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tieba.im.g<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity aAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewFriendsActivity newFriendsActivity) {
        this.aAt = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: y */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.aAt.aAm;
        bbVar.Gc().setData(list);
        bbVar2 = this.aAt.aAm;
        bbVar2.Gc().notifyDataSetChanged();
    }
}
