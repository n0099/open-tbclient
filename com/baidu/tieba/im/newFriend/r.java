package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long aOU;
    final /* synthetic */ o bgB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, long j) {
        this.bgB = oVar;
        this.aOU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        if (0 != this.aOU && com.baidu.tieba.im.db.m.MK().P(this.aOU)) {
            com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
            eVar.setId(this.aOU);
            eVar.setStatus(3);
            eVar.fw(0);
            com.baidu.tieba.im.db.m.MK().b(eVar);
        }
        return null;
    }
}
