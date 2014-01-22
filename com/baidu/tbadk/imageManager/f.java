package com.baidu.tbadk.imageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.d> {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.d.a
    /* renamed from: a */
    public int b(String str, com.baidu.adp.widget.ImageView.d dVar) {
        if (dVar != null) {
            return dVar.f();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.d.a
    public void a(boolean z, String str, com.baidu.adp.widget.ImageView.d dVar, com.baidu.adp.widget.ImageView.d dVar2) {
        com.baidu.adp.lib.d.a aVar;
        if (dVar != null) {
            if (com.baidu.adp.lib.g.e.a()) {
                StringBuilder append = new StringBuilder().append("pic removed from cache:").append(dVar.j()).append(", size:").append(dVar.f()).append("/");
                aVar = this.a.c;
                com.baidu.adp.lib.g.e.d(append.append(aVar.c()).toString());
            }
            dVar.g();
        }
    }
}
