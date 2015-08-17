package com.baidu.tieba.im;
/* loaded from: classes.dex */
class c extends h<Integer> {
    final /* synthetic */ b bmM;
    private final /* synthetic */ boolean bmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.bmM = bVar;
        this.bmN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Integer doInBackground() {
        if (!this.bmN) {
            com.baidu.tieba.im.db.b.ST().SU();
        }
        return 0;
    }
}
