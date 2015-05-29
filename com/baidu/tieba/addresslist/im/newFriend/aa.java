package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long azU;
    final /* synthetic */ x azW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, long j) {
        this.azW = xVar;
        this.azU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        if (0 != this.azU && ba.FW().I(this.azU)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.azU);
            bVar.setStatus(2);
            bVar.fY(0);
            ba.FW().h(bVar);
        }
        return null;
    }
}
