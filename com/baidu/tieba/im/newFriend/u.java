package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long beo;
    final /* synthetic */ t bgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, long j) {
        this.bgR = tVar;
        this.beo = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        if (0 != this.beo) {
            com.baidu.tieba.im.db.m.MO().O(this.beo);
            com.baidu.tieba.im.db.o.MU().fW(String.valueOf(this.beo));
        }
        return null;
    }
}
