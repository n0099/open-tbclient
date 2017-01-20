package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.aqr = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onCancelled(String str) {
        this.aqr.aqi = false;
        this.aqr.aqa.setVisibility(0);
        this.aqr.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aqr.aqi = false;
        this.aqr.aqh = true;
        this.aqr.mProgressBar.setVisibility(8);
        this.aqr.b(aVar);
    }
}
