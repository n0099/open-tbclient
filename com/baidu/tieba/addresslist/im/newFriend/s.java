package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class s extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ p ayh;
    private final /* synthetic */ long ayj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, long j) {
        this.ayh = pVar;
        this.ayj = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        if (0 != this.ayj && ba.Fd().J(this.ayj)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.ayj);
            bVar.setStatus(3);
            bVar.fH(0);
            ba.Fd().h(bVar);
        }
        return null;
    }
}
