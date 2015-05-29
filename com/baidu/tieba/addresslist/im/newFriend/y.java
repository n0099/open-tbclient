package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b azO;
    private final /* synthetic */ long azQ;
    final /* synthetic */ x azW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.azW = xVar;
        this.azQ = j;
        this.azO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b J;
        if (0 != this.azQ && (J = ba.FW().J(this.azQ)) != null) {
            this.azO.setContent(J.getContent());
            this.azO.setName(J.getName());
            this.azO.setPortrait(J.getPortrait());
            ba.FW().g(this.azO);
        }
        return null;
    }
}
