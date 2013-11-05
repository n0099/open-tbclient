package com.baidu.tbadk.imageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.d.a<String, com.baidu.adp.widget.ImageView.e> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f964a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.f964a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.d.a
    /* renamed from: a */
    public int b(String str, com.baidu.adp.widget.ImageView.e eVar) {
        if (eVar != null) {
            return eVar.d();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.d.a
    public void a(boolean z, String str, com.baidu.adp.widget.ImageView.e eVar, com.baidu.adp.widget.ImageView.e eVar2) {
        com.baidu.adp.lib.d.a aVar;
        if (eVar != null) {
            if (com.baidu.adp.lib.h.d.a()) {
                StringBuilder append = new StringBuilder().append("pic removed from cache:").append(eVar.i()).append(", size:").append(eVar.d()).append("/");
                aVar = this.f964a.c;
                com.baidu.adp.lib.h.d.d(append.append(aVar.c()).toString());
            }
            eVar.e();
        }
    }
}
