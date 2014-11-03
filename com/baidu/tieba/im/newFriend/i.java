package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic bgL;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.e eVar) {
        this.bgL = newFriendDbManagerStatic;
        this.bgM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        com.baidu.tieba.im.db.m.MO().a(this.bgM);
        return null;
    }
}
