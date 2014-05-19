package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar != null) {
            this.a.a(aVar);
            this.a.b(aVar);
            if (this.a.b() && !z) {
                this.b.a(this.a);
            }
        }
    }
}
