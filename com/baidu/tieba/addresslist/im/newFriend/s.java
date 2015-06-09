package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class s extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ p azT;
    private final /* synthetic */ long azV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, long j) {
        this.azT = pVar;
        this.azV = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        if (0 != this.azV && ba.FX().I(this.azV)) {
            com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
            bVar.setId(this.azV);
            bVar.setStatus(3);
            bVar.fY(0);
            ba.FX().h(bVar);
        }
        return null;
    }
}
