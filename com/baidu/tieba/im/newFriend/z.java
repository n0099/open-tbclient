package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long aQT;
    final /* synthetic */ w bjK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, long j) {
        this.bjK = wVar;
        this.aQT = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        if (0 != this.aQT && com.baidu.tieba.im.db.m.MI().W(this.aQT)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.aQT);
            bVar.setStatus(2);
            bVar.fz(0);
            com.baidu.tieba.im.db.m.MI().c(bVar);
        }
        return null;
    }
}
