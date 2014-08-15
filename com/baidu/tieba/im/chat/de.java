package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ dd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(dd ddVar) {
        this.a = ddVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String a;
        super.a((de) aVar, str, i);
        if (aVar != null) {
            dd ddVar = this.a;
            a = this.a.a(this.a.a, aVar.k());
            ddVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(com.baidu.tieba.x.save_error));
    }
}
