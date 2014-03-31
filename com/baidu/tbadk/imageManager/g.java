package com.baidu.tbadk.imageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.b> {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar, int i) {
        super(0);
        this.a = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // com.baidu.adp.lib.d.a
    protected final /* synthetic */ void a(boolean z, String str, com.baidu.adp.widget.ImageView.b bVar, com.baidu.adp.widget.ImageView.b bVar2) {
        com.baidu.adp.lib.d.a aVar;
        com.baidu.adp.widget.ImageView.b bVar3 = bVar;
        if (bVar3 != null) {
            if (com.baidu.adp.lib.util.f.a()) {
                StringBuilder append = new StringBuilder("pic removed from cache:").append(bVar3.j()).append(", size:").append(bVar3.f()).append("/");
                aVar = this.a.c;
                com.baidu.adp.lib.util.f.e(append.append(aVar.b()).toString());
            }
            bVar3.g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.baidu.adp.lib.d.a
    protected final /* synthetic */ int b(String str, com.baidu.adp.widget.ImageView.b bVar) {
        com.baidu.adp.widget.ImageView.b bVar2 = bVar;
        if (bVar2 != null) {
            return bVar2.f();
        }
        return 0;
    }
}
