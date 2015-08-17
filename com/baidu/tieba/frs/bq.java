package com.baidu.tieba.frs;

import android.widget.ImageView;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements j.a {
    final /* synthetic */ bp aXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.aXD = bpVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void dv(int i) {
        bl blVar;
        bl blVar2;
        com.baidu.tieba.tbadkCore.n nVar;
        bl blVar3;
        ImageView imageView;
        if (i == 0) {
            blVar3 = this.aXD.aXC;
            imageView = blVar3.aXn;
            imageView.setVisibility(8);
            return;
        }
        blVar = this.aXD.aXC;
        blVar2 = this.aXD.aXC;
        nVar = blVar2.aUy;
        blVar.b(nVar);
    }
}
