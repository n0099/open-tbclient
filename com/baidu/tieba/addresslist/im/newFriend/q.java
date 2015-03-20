package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;
    private final /* synthetic */ long axX;
    final /* synthetic */ p axZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.axZ = pVar;
        this.axX = j;
        this.axV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b K = ba.EX().K(this.axX);
        if (K != null) {
            this.axV.setName(K.getName());
            this.axV.setPortrait(K.getPortrait());
            ba.EX().g(this.axV);
        }
        return null;
    }
}
