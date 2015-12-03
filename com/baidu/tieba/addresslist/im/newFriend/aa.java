package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aa extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ x aIA;
    private final /* synthetic */ long aIy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, long j) {
        this.aIA = xVar;
        this.aIy = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        if (0 != this.aIy && aw.Hr().aj(this.aIy)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.aIy);
            bVar.setStatus(2);
            bVar.hQ(0);
            aw.Hr().h(bVar);
        }
        return null;
    }
}
