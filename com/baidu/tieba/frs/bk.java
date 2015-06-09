package com.baidu.tieba.frs;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ bj aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar) {
        this.aOo = bjVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void dk(int i) {
        bf bfVar;
        bf bfVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        bf bfVar3;
        ImageView imageView;
        if (i == 0) {
            bfVar3 = this.aOo.aOn;
            imageView = bfVar3.aNX;
            imageView.setVisibility(8);
            return;
        }
        bfVar = this.aOo.aOn;
        bfVar2 = this.aOo.aOn;
        wVar = bfVar2.aLm;
        bfVar.b(wVar);
    }
}
