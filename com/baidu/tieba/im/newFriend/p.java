package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long beo;
    private final /* synthetic */ com.baidu.tieba.im.data.e bgM;
    final /* synthetic */ o bgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, long j, com.baidu.tieba.im.data.e eVar) {
        this.bgP = oVar;
        this.beo = j;
        this.bgM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        com.baidu.tieba.im.data.e Q = com.baidu.tieba.im.db.m.MO().Q(this.beo);
        if (Q != null) {
            this.bgM.setName(Q.getName());
            this.bgM.setPortrait(Q.getPortrait());
            com.baidu.tieba.im.db.m.MO().a(this.bgM);
        }
        return null;
    }
}
