package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bhG;
    final /* synthetic */ t bjJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, long j) {
        this.bjJ = tVar;
        this.bhG = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        if (0 != this.bhG) {
            com.baidu.tieba.im.db.m.MI().V(this.bhG);
            com.baidu.tieba.im.db.o.MO().gl(String.valueOf(this.bhG));
        }
        return null;
    }
}
