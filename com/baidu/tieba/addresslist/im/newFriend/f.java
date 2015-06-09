package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azO;
    private final /* synthetic */ long azR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.azO = newFriendDbManagerStatic;
        this.azR = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        ba.FX().H(this.azR);
        return null;
    }
}
