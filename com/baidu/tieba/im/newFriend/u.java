package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bjb;
    final /* synthetic */ t blg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, long j) {
        this.blg = tVar;
        this.bjb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        if (0 != this.bjb) {
            com.baidu.tieba.im.db.m.Ne().V(this.bjb);
            com.baidu.tieba.im.db.o.Nk().gq(String.valueOf(this.bjb));
        }
        return null;
    }
}
