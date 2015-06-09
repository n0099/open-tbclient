package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b azP;
    private final /* synthetic */ long azR;
    final /* synthetic */ x azX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.azX = xVar;
        this.azR = j;
        this.azP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b J;
        if (0 != this.azR && (J = ba.FX().J(this.azR)) != null) {
            this.azP.setContent(J.getContent());
            this.azP.setName(J.getName());
            this.azP.setPortrait(J.getPortrait());
            ba.FX().g(this.azP);
        }
        return null;
    }
}
