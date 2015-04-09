package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b ayd;
    private final /* synthetic */ long ayf;
    final /* synthetic */ p ayh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.ayh = pVar;
        this.ayf = j;
        this.ayd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b K = ba.Fd().K(this.ayf);
        if (K != null) {
            this.ayd.setName(K.getName());
            this.ayd.setPortrait(K.getPortrait());
            ba.Fd().g(this.ayd);
        }
        return null;
    }
}
