package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements com.baidu.tieba.im.g<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity aAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewFriendsActivity newFriendsActivity) {
        this.aAs = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: y */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.aAs.aAl;
        bbVar.completePullRefresh();
        bbVar2 = this.aAs.aAl;
        bbVar2.setData(list);
    }
}
