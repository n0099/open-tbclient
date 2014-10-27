package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long bea;
    final /* synthetic */ t bgD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, long j) {
        this.bgD = tVar;
        this.bea = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        if (0 != this.bea) {
            com.baidu.tieba.im.db.m.MK().O(this.bea);
            com.baidu.tieba.im.db.o.MQ().fW(String.valueOf(this.bea));
        }
        return null;
    }
}
