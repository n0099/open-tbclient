package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long azV;
    final /* synthetic */ x azX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, long j) {
        this.azX = xVar;
        this.azV = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        if (0 != this.azV && ba.FX().I(this.azV)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.azV);
            bVar.setStatus(2);
            bVar.fY(0);
            ba.FX().h(bVar);
        }
        return null;
    }
}
