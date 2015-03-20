package com.baidu.tieba.frs;

import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ bk aLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.aLS = bkVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void onVisibleChange(int i) {
        bf bfVar;
        bf bfVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        bf bfVar3;
        ImageView imageView;
        if (i == 0) {
            bfVar3 = this.aLS.aLR;
            imageView = bfVar3.aLC;
            imageView.setVisibility(8);
            return;
        }
        bfVar = this.aLS.aLR;
        bfVar2 = this.aLS.aLR;
        wVar = bfVar2.aIV;
        bfVar.b(wVar);
    }
}
