package com.baidu.tieba.data.emotions;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            this.b.a(dVar);
            this.b.b(dVar);
            if (this.b.b()) {
                this.a.a(this.b);
            }
        }
    }
}
