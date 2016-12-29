package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u arl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.arl = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ai(String str) {
        this.arl.arc = false;
        this.arl.aqU.setVisibility(0);
        this.arl.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.arl.arc = false;
        this.arl.arb = true;
        this.arl.mProgressBar.setVisibility(8);
        this.arl.b(aVar);
    }
}
