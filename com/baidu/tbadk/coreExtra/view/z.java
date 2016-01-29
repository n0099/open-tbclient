package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u aqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.aqx = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void am(String str) {
        this.aqx.aqo = false;
        this.aqx.aqh.setVisibility(0);
        this.aqx.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aqx.aqo = false;
        this.aqx.aqn = true;
        this.aqx.mProgressBar.setVisibility(8);
        this.aqx.b(aVar);
    }
}
