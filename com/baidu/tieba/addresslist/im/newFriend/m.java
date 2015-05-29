package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b azO;
    private final /* synthetic */ long azQ;
    final /* synthetic */ l azR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.azR = lVar;
        this.azQ = j;
        this.azO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        if (!ba.FW().I(this.azQ)) {
            ba.FW().g(this.azO);
            return null;
        }
        return null;
    }
}
