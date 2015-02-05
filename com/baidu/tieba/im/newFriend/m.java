package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bja;
    private final /* synthetic */ com.baidu.tieba.im.data.b bla;
    final /* synthetic */ l blc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.blc = lVar;
        this.bja = j;
        this.bla = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        if (!com.baidu.tieba.im.db.m.MZ().W(this.bja)) {
            com.baidu.tieba.im.db.m.MZ().b(this.bla);
            return null;
        }
        return null;
    }
}
