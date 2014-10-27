package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long aOU;
    final /* synthetic */ w bgE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, long j) {
        this.bgE = wVar;
        this.aOU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        if (0 != this.aOU && com.baidu.tieba.im.db.m.MK().P(this.aOU)) {
            com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
            eVar.setId(this.aOU);
            eVar.setStatus(2);
            eVar.fw(0);
            com.baidu.tieba.im.db.m.MK().b(eVar);
        }
        return null;
    }
}
