package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b aVV;
    private final /* synthetic */ boolean aVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.aVV = bVar;
        this.aVW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.aVW) {
            com.baidu.tieba.im.db.b.PI().PJ();
        }
        return 0;
    }
}
