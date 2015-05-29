package com.baidu.tieba.frs;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ bj aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.aOn = bjVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void dk(int i) {
        bf bfVar;
        bf bfVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        bf bfVar3;
        ImageView imageView;
        if (i == 0) {
            bfVar3 = this.aOn.aOm;
            imageView = bfVar3.aNW;
            imageView.setVisibility(8);
            return;
        }
        bfVar = this.aOn.aOm;
        bfVar2 = this.aOn.aOm;
        wVar = bfVar2.aLl;
        bfVar.b(wVar);
    }
}
