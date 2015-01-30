package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bjb;
    private final /* synthetic */ com.baidu.tieba.im.data.b blb;
    final /* synthetic */ w blh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.blh = wVar;
        this.bjb = j;
        this.blb = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b X;
        if (0 != this.bjb && (X = com.baidu.tieba.im.db.m.Ne().X(this.bjb)) != null) {
            this.blb.setContent(X.getContent());
            this.blb.setName(X.getName());
            this.blb.setPortrait(X.getPortrait());
            com.baidu.tieba.im.db.m.Ne().b(this.blb);
        }
        return null;
    }
}
