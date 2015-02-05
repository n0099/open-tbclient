package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long aSb;
    final /* synthetic */ o bld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, long j) {
        this.bld = oVar;
        this.aSb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        if (0 != this.aSb && com.baidu.tieba.im.db.m.MZ().W(this.aSb)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.aSb);
            bVar.setStatus(3);
            bVar.fE(0);
            com.baidu.tieba.im.db.m.MZ().c(bVar);
        }
        return null;
    }
}
