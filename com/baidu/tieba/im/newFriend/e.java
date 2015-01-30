package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bjb;
    final /* synthetic */ NewFriendDbManagerStatic bla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bla = newFriendDbManagerStatic;
        this.bjb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.Ne().V(this.bjb);
        return null;
    }
}
