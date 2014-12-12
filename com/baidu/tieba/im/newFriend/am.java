package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.im.h<List<com.baidu.tieba.im.data.b>> {
    final /* synthetic */ NewFriendsActivity bke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewFriendsActivity newFriendsActivity) {
        this.bke = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: RH */
    public List<com.baidu.tieba.im.data.b> doInBackground() {
        return com.baidu.tieba.im.db.m.MI().MM();
    }
}
