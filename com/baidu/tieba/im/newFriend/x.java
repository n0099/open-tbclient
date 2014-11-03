package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long beo;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;
    final /* synthetic */ w bgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, long j, com.baidu.tieba.im.data.e eVar) {
        this.bgS = wVar;
        this.beo = j;
        this.bgM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        com.baidu.tieba.im.data.e Q;
        if (0 != this.beo && (Q = com.baidu.tieba.im.db.m.MO().Q(this.beo)) != null) {
            this.bgM.setContent(Q.getContent());
            this.bgM.setName(Q.getName());
            this.bgM.setPortrait(Q.getPortrait());
            com.baidu.tieba.im.db.m.MO().a(this.bgM);
        }
        return null;
    }
}
