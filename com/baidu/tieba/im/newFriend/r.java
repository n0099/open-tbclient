package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long aQT;
    final /* synthetic */ o bjH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, long j) {
        this.bjH = oVar;
        this.aQT = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        if (0 != this.aQT && com.baidu.tieba.im.db.m.MI().W(this.aQT)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.aQT);
            bVar.setStatus(3);
            bVar.fz(0);
            com.baidu.tieba.im.db.m.MI().c(bVar);
        }
        return null;
    }
}
