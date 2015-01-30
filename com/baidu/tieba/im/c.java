package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b aQJ;
    private final /* synthetic */ boolean aQK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.aQJ = bVar;
        this.aQK = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.aQK) {
            com.baidu.tieba.im.db.b.MO().MP();
        }
        return 0;
    }
}
