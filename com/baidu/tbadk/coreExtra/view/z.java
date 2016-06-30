package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.ani = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void af(String str) {
        this.ani.amZ = false;
        this.ani.amS.setVisibility(0);
        this.ani.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.ani.amZ = false;
        this.ani.amY = true;
        this.ani.mProgressBar.setVisibility(8);
        this.ani.b(aVar);
    }
}
