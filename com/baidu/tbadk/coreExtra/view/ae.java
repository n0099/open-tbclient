package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z amo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.amo = zVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void aj(String str) {
        this.amo.amb.setVisibility(0);
        this.amo.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.amo.amg = true;
        this.amo.mProgressBar.setVisibility(8);
        this.amo.b(aVar);
    }
}
