package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bjb;
    private final /* synthetic */ com.baidu.tieba.im.data.b blb;
    final /* synthetic */ l bld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.bld = lVar;
        this.bjb = j;
        this.blb = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        if (!com.baidu.tieba.im.db.m.Ne().W(this.bjb)) {
            com.baidu.tieba.im.db.m.Ne().b(this.blb);
            return null;
        }
        return null;
    }
}
