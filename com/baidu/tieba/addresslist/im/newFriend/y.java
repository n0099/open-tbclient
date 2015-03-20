package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b axV;
    private final /* synthetic */ long axX;
    final /* synthetic */ x ayd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.ayd = xVar;
        this.axX = j;
        this.axV = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b K;
        if (0 != this.axX && (K = ba.EX().K(this.axX)) != null) {
            this.axV.setContent(K.getContent());
            this.axV.setName(K.getName());
            this.axV.setPortrait(K.getPortrait());
            ba.EX().g(this.axV);
        }
        return null;
    }
}
