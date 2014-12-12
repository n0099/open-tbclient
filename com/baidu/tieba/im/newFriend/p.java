package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bhG;
    private final /* synthetic */ com.baidu.tieba.im.data.b bjE;
    final /* synthetic */ o bjH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.bjH = oVar;
        this.bhG = j;
        this.bjE = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b X = com.baidu.tieba.im.db.m.MI().X(this.bhG);
        if (X != null) {
            this.bjE.setName(X.getName());
            this.bjE.setPortrait(X.getPortrait());
            com.baidu.tieba.im.db.m.MI().b(this.bjE);
        }
        return null;
    }
}
