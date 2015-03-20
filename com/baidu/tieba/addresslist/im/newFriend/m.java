package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;
    private final /* synthetic */ long axX;
    final /* synthetic */ l axY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.axY = lVar;
        this.axX = j;
        this.axV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        if (!ba.EX().J(this.axX)) {
            ba.EX().g(this.axV);
            return null;
        }
        return null;
    }
}
