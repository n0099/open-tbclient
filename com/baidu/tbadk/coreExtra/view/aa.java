package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ u arI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.arI = uVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ai(String str) {
        this.arI.arz = false;
        this.arI.arr.setVisibility(0);
        this.arI.mProgressBar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.arI.arz = false;
        this.arI.ary = true;
        this.arI.mProgressBar.setVisibility(8);
        this.arI.b(aVar);
    }
}
