package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long aSc;
    final /* synthetic */ w blh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, long j) {
        this.blh = wVar;
        this.aSc = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        if (0 != this.aSc && com.baidu.tieba.im.db.m.Ne().W(this.aSc)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.aSc);
            bVar.setStatus(2);
            bVar.fE(0);
            com.baidu.tieba.im.db.m.Ne().c(bVar);
        }
        return null;
    }
}
