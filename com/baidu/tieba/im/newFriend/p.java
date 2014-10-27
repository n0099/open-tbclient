package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long bea;
    final /* synthetic */ o bgB;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, long j, com.baidu.tieba.im.data.e eVar) {
        this.bgB = oVar;
        this.bea = j;
        this.bgy = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        com.baidu.tieba.im.data.e Q = com.baidu.tieba.im.db.m.MK().Q(this.bea);
        if (Q != null) {
            this.bgy.setName(Q.getName());
            this.bgy.setPortrait(Q.getPortrait());
            com.baidu.tieba.im.db.m.MK().a(this.bgy);
        }
        return null;
    }
}
