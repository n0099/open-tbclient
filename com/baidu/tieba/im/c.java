package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b bnk;
    private final /* synthetic */ boolean bnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.bnk = bVar;
        this.bnl = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.bnl) {
            com.baidu.tieba.im.db.b.SV().SW();
        }
        return 0;
    }
}
