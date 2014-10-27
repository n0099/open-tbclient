package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a Rk;
    private final /* synthetic */ c Rl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.Rk = aVar;
        this.Rl = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((b) aVar, str, i);
        if (aVar != null) {
            this.Rk.b(aVar);
            this.Rk.c(aVar);
            if (this.Rk.rq() && i == 3) {
                this.Rl.a(this.Rk);
            }
        }
    }
}
