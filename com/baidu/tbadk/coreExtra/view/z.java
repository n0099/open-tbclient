package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u are;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.are = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ai(String str) {
        this.are.aqV = false;
        this.are.aqO.setVisibility(0);
        this.are.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.are.aqV = false;
        this.are.aqU = true;
        this.are.mProgressBar.setVisibility(8);
        this.are.b(aVar);
    }
}
