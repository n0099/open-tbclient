package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a XR;
    private final /* synthetic */ c XS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.XR = aVar;
        this.XS = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((b) aVar, str, i);
        if (aVar != null) {
            this.XR.b(aVar);
            this.XR.c(aVar);
            if (this.XR.isReady()) {
                this.XS.a(this.XR);
            }
        }
    }
}
