package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements com.baidu.tieba.im.g<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity ayH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(NewFriendsActivity newFriendsActivity) {
        this.ayH = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: x */
    public void onReturnDataInUI(List<com.baidu.tieba.im.data.b> list) {
        bb bbVar;
        bb bbVar2;
        bbVar = this.ayH.ayA;
        bbVar.mW();
        bbVar2 = this.ayH.ayA;
        bbVar2.setData(list);
    }
}
