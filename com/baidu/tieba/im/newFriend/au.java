package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.tieba.im.h<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity blA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(NewFriendsActivity newFriendsActivity) {
        this.blA = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: RY */
    public List<com.baidu.tieba.im.data.b> doInBackground() {
        return com.baidu.tieba.im.db.m.MZ().Nc();
    }
}
