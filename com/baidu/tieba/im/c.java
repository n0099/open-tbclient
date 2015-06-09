package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b aYR;
    private final /* synthetic */ boolean aYS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.aYR = bVar;
        this.aYS = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.aYS) {
            com.baidu.tieba.im.db.b.Rl().Rm();
        }
        return 0;
    }
}
