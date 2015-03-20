package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long ayb;
    final /* synthetic */ x ayd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, long j) {
        this.ayd = xVar;
        this.ayb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        if (0 != this.ayb && ba.EX().J(this.ayb)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.ayb);
            bVar.setStatus(2);
            bVar.fF(0);
            ba.EX().h(bVar);
        }
        return null;
    }
}
