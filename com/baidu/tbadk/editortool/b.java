package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a Ro;
    private final /* synthetic */ c Rp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.Ro = aVar;
        this.Rp = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((b) aVar, str, i);
        if (aVar != null) {
            this.Ro.b(aVar);
            this.Ro.c(aVar);
            if (this.Ro.rs() && i == 3) {
                this.Rp.a(this.Ro);
            }
        }
    }
}
