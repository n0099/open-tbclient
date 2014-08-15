package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((b) aVar, str, i);
        if (aVar != null) {
            this.a.a(aVar);
            this.a.b(aVar);
            if (this.a.b() && i == 3) {
                this.b.a(this.a);
            }
        }
    }
}
