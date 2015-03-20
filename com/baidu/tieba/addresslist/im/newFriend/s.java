package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class s extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ p axZ;
    private final /* synthetic */ long ayb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, long j) {
        this.axZ = pVar;
        this.ayb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        if (0 != this.ayb && ba.EX().J(this.ayb)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.ayb);
            bVar.setStatus(3);
            bVar.fF(0);
            ba.EX().h(bVar);
        }
        return null;
    }
}
