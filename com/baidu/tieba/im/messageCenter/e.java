package com.baidu.tieba.im.messageCenter;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Integer> {
    final /* synthetic */ d beK;
    private final /* synthetic */ boolean beL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.beK = dVar;
        this.beL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Qu */
    public Integer doInBackground() {
        if (!this.beL) {
            com.baidu.tieba.im.db.b.Mz().KF();
        }
        return 0;
    }
}
