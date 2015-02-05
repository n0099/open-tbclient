package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bja;
    private final /* synthetic */ com.baidu.tieba.im.data.b bla;
    final /* synthetic */ w blg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.blg = wVar;
        this.bja = j;
        this.bla = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b X;
        if (0 != this.bja && (X = com.baidu.tieba.im.db.m.MZ().X(this.bja)) != null) {
            this.bla.setContent(X.getContent());
            this.bla.setName(X.getName());
            this.bla.setPortrait(X.getPortrait());
            com.baidu.tieba.im.db.m.MZ().b(this.bla);
        }
        return null;
    }
}
