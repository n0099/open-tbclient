package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long ayj;
    final /* synthetic */ x ayl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, long j) {
        this.ayl = xVar;
        this.ayj = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        if (0 != this.ayj && ba.Fd().J(this.ayj)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.ayj);
            bVar.setStatus(2);
            bVar.fH(0);
            ba.Fd().h(bVar);
        }
        return null;
    }
}
