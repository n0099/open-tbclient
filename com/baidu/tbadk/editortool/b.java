package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
class b extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ a XO;
    private final /* synthetic */ c XP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.XO = aVar;
        this.XP = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((b) aVar, str, i);
        if (aVar != null) {
            this.XO.b(aVar);
            this.XO.c(aVar);
            if (this.XO.isReady()) {
                this.XP.a(this.XO);
            }
        }
    }
}
