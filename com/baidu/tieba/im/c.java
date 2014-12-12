package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b aPE;
    private final /* synthetic */ boolean aPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.aPE = bVar;
        this.aPF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.aPF) {
            com.baidu.tieba.im.db.b.Ms().Mt();
        }
        return 0;
    }
}
