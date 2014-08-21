package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ df a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.a = dfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        String a;
        super.a((dg) aVar, str, i);
        if (aVar != null) {
            df dfVar = this.a;
            a = this.a.a(this.a.a, aVar.k());
            dfVar.a(a);
            return;
        }
        this.a.a(this.a.b.getString(com.baidu.tieba.x.save_error));
    }
}
