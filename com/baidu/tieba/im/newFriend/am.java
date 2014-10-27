package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class am extends com.baidu.tieba.im.b<List<com.baidu.tieba.im.data.e>> {
    final /* synthetic */ NewFriendsActivity bgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewFriendsActivity newFriendsActivity) {
        this.bgY = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Rk */
    public List<com.baidu.tieba.im.data.e> doInBackground() {
        return com.baidu.tieba.im.db.m.MK().MO();
    }
}
