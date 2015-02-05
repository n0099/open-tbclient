package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bja;
    final /* synthetic */ NewFriendDbManagerStatic bkZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bkZ = newFriendDbManagerStatic;
        this.bja = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MZ().V(this.bja);
        return null;
    }
}
