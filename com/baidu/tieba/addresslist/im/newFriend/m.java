package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ com.baidu.tieba.im.data.b ayd;
    private final /* synthetic */ long ayf;
    final /* synthetic */ l ayg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.ayg = lVar;
        this.ayf = j;
        this.ayd = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        if (!ba.Fd().J(this.ayf)) {
            ba.Fd().g(this.ayd);
            return null;
        }
        return null;
    }
}
