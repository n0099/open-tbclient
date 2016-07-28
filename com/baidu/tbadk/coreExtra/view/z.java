package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u anX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.anX = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ah(String str) {
        this.anX.anO = false;
        this.anX.anH.setVisibility(0);
        this.anX.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.anX.anO = false;
        this.anX.anN = true;
        this.anX.mProgressBar.setVisibility(8);
        this.anX.b(aVar);
    }
}
