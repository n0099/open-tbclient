package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long bea;
    final /* synthetic */ w bgE;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, long j, com.baidu.tieba.im.data.e eVar) {
        this.bgE = wVar;
        this.bea = j;
        this.bgy = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        com.baidu.tieba.im.data.e Q;
        if (0 != this.bea && (Q = com.baidu.tieba.im.db.m.MK().Q(this.bea)) != null) {
            this.bgy.setContent(Q.getContent());
            this.bgy.setName(Q.getName());
            this.bgy.setPortrait(Q.getPortrait());
            com.baidu.tieba.im.db.m.MK().a(this.bgy);
        }
        return null;
    }
}
