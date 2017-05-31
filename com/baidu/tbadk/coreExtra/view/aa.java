package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u avS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.avS = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onCancelled(String str) {
        this.avS.avJ = false;
        this.avS.avB.setVisibility(0);
        this.avS.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.avS.avJ = false;
        this.avS.avI = true;
        this.avS.mProgressBar.setVisibility(8);
        this.avS.b(aVar);
    }
}
