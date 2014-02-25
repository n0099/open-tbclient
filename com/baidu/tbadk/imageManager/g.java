package com.baidu.tbadk.imageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b> {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(i);
        this.a = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.d.a
    /* renamed from: a */
    public int b(String str, com.baidu.adp.widget.ImageView.b bVar) {
        if (bVar != null) {
            return bVar.f();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.d.a
    public void a(boolean z, String str, com.baidu.adp.widget.ImageView.b bVar, com.baidu.adp.widget.ImageView.b bVar2) {
        com.baidu.adp.lib.d.a aVar;
        if (bVar != null) {
            if (com.baidu.adp.lib.util.f.a()) {
                StringBuilder append = new StringBuilder("pic removed from cache:").append(bVar.j()).append(", size:").append(bVar.f()).append("/");
                aVar = this.a.c;
                com.baidu.adp.lib.util.f.e(append.append(aVar.c()).toString());
            }
            bVar.g();
        }
    }
}
