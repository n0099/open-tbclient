package com.baidu.tbadk.editortool;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.a.a(bVar);
            this.a.b(bVar);
            if (this.a.b() && !z) {
                c cVar = this.b;
                a aVar = this.a;
                cVar.a();
            }
        }
    }
}
