package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b aYQ;
    private final /* synthetic */ boolean aYR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.aYQ = bVar;
        this.aYR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.aYR) {
            com.baidu.tieba.im.db.b.Rk().Rl();
        }
        return 0;
    }
}
