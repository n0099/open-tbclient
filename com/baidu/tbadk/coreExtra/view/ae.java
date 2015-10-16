package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ z amj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.amj = zVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void al(String str) {
        this.amj.alW.setVisibility(0);
        this.amj.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.amj.amb = true;
        this.amj.mProgressBar.setVisibility(8);
        this.amj.b(aVar);
    }
}
