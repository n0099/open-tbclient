package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long bea;
    final /* synthetic */ NewFriendDbManagerStatic bgx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.bgx = newFriendDbManagerStatic;
        this.bea = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MK().O(this.bea);
        return null;
    }
}
