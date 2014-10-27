package com.baidu.tieba.im.messageCenter;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Integer> {
    final /* synthetic */ d bew;
    private final /* synthetic */ boolean bex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.bew = dVar;
        this.bex = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Qr */
    public Integer doInBackground() {
        if (!this.bex) {
            com.baidu.tieba.im.db.b.Mv().KB();
        }
        return 0;
    }
}
