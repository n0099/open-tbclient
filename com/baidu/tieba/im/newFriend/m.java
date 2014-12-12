package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bhG;
    private final /* synthetic */ com.baidu.tieba.im.data.b bjE;
    final /* synthetic */ l bjG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.bjG = lVar;
        this.bhG = j;
        this.bjE = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        if (!com.baidu.tieba.im.db.m.MI().W(this.bhG)) {
            com.baidu.tieba.im.db.m.MI().b(this.bjE);
            return null;
        }
        return null;
    }
}
