package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long azR;
    final /* synthetic */ u azW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, long j) {
        this.azW = uVar;
        this.azR = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        if (0 != this.azR) {
            ba.FX().H(this.azR);
            com.baidu.tieba.im.db.n.RC().gV(String.valueOf(this.azR));
        }
        return null;
    }
}
