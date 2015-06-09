package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b azP;
    private final /* synthetic */ long azR;
    final /* synthetic */ l azS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.azS = lVar;
        this.azR = j;
        this.azP = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        if (!ba.FX().I(this.azR)) {
            ba.FX().g(this.azP);
            return null;
        }
        return null;
    }
}
