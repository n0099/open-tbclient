package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long bhG;
    private final /* synthetic */ com.baidu.tieba.im.data.b bjE;
    final /* synthetic */ w bjK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.bjK = wVar;
        this.bhG = j;
        this.bjE = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b X;
        if (0 != this.bhG && (X = com.baidu.tieba.im.db.m.MI().X(this.bhG)) != null) {
            this.bjE.setContent(X.getContent());
            this.bjE.setName(X.getName());
            this.bjE.setPortrait(X.getPortrait());
            com.baidu.tieba.im.db.m.MI().b(this.bjE);
        }
        return null;
    }
}
