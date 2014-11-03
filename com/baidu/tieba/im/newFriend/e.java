package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long beo;
    final /* synthetic */ NewFriendDbManagerStatic bgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bgL = newFriendDbManagerStatic;
        this.beo = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MO().O(this.beo);
        return null;
    }
}
