package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ NewFriendDbManagerStatic ayc;
    private final /* synthetic */ long ayf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
        this.ayc = newFriendDbManagerStatic;
        this.ayf = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        ba.Fd().I(this.ayf);
        return null;
    }
}
