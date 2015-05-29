package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long azQ;
    final /* synthetic */ u azV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, long j) {
        this.azV = uVar;
        this.azQ = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        if (0 != this.azQ) {
            ba.FW().H(this.azQ);
            com.baidu.tieba.im.db.n.RB().gV(String.valueOf(this.azQ));
        }
        return null;
    }
}
