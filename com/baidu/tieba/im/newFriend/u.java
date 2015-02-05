package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bja;
    final /* synthetic */ t blf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, long j) {
        this.blf = tVar;
        this.bja = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        if (0 != this.bja) {
            com.baidu.tieba.im.db.m.MZ().V(this.bja);
            com.baidu.tieba.im.db.o.Nf().gn(String.valueOf(this.bja));
        }
        return null;
    }
}
