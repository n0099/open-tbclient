package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b ayd;
    private final /* synthetic */ long ayf;
    final /* synthetic */ x ayl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.ayl = xVar;
        this.ayf = j;
        this.ayd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b K;
        if (0 != this.ayf && (K = ba.Fd().K(this.ayf)) != null) {
            this.ayd.setContent(K.getContent());
            this.ayd.setName(K.getName());
            this.ayd.setPortrait(K.getPortrait());
            ba.Fd().g(this.ayd);
        }
        return null;
    }
}
