package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bhG;
    final /* synthetic */ NewFriendDbManagerStatic bjD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bjD = newFriendDbManagerStatic;
        this.bhG = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MI().V(this.bhG);
        return null;
    }
}
