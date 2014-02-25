package com.baidu.tieba.data.emotions;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ a a;
    private final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.a.a(bVar);
            this.a.b(bVar);
            if (this.a.b() && !z) {
                this.b.a(this.a);
            }
        }
    }
}
