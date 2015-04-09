package com.baidu.tieba.frs;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ bk aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.aMd = bkVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void onVisibleChange(int i) {
        bf bfVar;
        bf bfVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        bf bfVar3;
        ImageView imageView;
        if (i == 0) {
            bfVar3 = this.aMd.aMc;
            imageView = bfVar3.aLM;
            imageView.setVisibility(8);
            return;
        }
        bfVar = this.aMd.aMc;
        bfVar2 = this.aMd.aMc;
        wVar = bfVar2.aJd;
        bfVar.b(wVar);
    }
}
