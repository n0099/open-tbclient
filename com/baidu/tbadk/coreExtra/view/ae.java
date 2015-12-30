package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z apF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.apF = zVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void an(String str) {
        this.apF.apw = false;
        this.apF.apo.setVisibility(0);
        this.apF.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.apF.apw = false;
        this.apF.apv = true;
        this.apF.mProgressBar.setVisibility(8);
        this.apF.b(aVar);
    }
}
