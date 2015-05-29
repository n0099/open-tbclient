package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b azO;
    private final /* synthetic */ long azQ;
    final /* synthetic */ p azS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.azS = pVar;
        this.azQ = j;
        this.azO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b J = ba.FW().J(this.azQ);
        if (J != null) {
            this.azO.setName(J.getName());
            this.azO.setPortrait(J.getPortrait());
            ba.FW().g(this.azO);
        }
        return null;
    }
}
