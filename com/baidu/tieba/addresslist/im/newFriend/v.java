package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long axX;
    final /* synthetic */ u ayc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, long j) {
        this.ayc = uVar;
        this.axX = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        if (0 != this.axX) {
            ba.EX().I(this.axX);
            com.baidu.tieba.im.db.n.PZ().gq(String.valueOf(this.axX));
        }
        return null;
    }
}
