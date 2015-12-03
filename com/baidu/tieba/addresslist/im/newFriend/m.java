package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;
    private final /* synthetic */ long aIu;
    final /* synthetic */ l aIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.aIv = lVar;
        this.aIu = j;
        this.aIs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        if (!aw.Hr().aj(this.aIu)) {
            aw.Hr().g(this.aIs);
            return null;
        }
        return null;
    }
}
