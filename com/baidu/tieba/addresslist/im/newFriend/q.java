package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class q extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;
    private final /* synthetic */ long aIu;
    final /* synthetic */ p aIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.aIw = pVar;
        this.aIu = j;
        this.aIs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b ak = aw.Hr().ak(this.aIu);
        if (ak != null) {
            this.aIs.setName(ak.getName());
            this.aIs.setPortrait(ak.getPortrait());
            aw.Hr().g(this.aIs);
        }
        return null;
    }
}
