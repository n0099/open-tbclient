package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long beo;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;
    final /* synthetic */ l bgO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.e eVar) {
        this.bgO = lVar;
        this.beo = j;
        this.bgM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        if (!com.baidu.tieba.im.db.m.MO().P(this.beo)) {
            com.baidu.tieba.im.db.m.MO().a(this.bgM);
            return null;
        }
        return null;
    }
}
