package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long bea;
    final /* synthetic */ l bgA;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.e eVar) {
        this.bgA = lVar;
        this.bea = j;
        this.bgy = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        if (!com.baidu.tieba.im.db.m.MK().P(this.bea)) {
            com.baidu.tieba.im.db.m.MK().a(this.bgy);
            return null;
        }
        return null;
    }
}
