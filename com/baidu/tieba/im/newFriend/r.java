package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ long aPi;
    final /* synthetic */ o bgP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, long j) {
        this.bgP = oVar;
        this.aPi = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        if (0 != this.aPi && com.baidu.tieba.im.db.m.MO().P(this.aPi)) {
            com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
            eVar.setId(this.aPi);
            eVar.setStatus(3);
            eVar.fw(0);
            com.baidu.tieba.im.db.m.MO().b(eVar);
        }
        return null;
    }
}
