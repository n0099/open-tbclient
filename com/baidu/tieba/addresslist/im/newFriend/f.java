package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic azN;
    private final /* synthetic */ long azQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.azN = newFriendDbManagerStatic;
        this.azQ = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        ba.FW().H(this.azQ);
        return null;
    }
}
