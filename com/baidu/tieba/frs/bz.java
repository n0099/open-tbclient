package com.baidu.tieba.frs;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ by aGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar) {
        this.aGh = byVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void onVisibleChange(int i) {
        bp bpVar;
        bp bpVar2;
        com.baidu.tieba.tbadkCore.e eVar;
        bp bpVar3;
        TextView textView;
        if (i == 0) {
            bpVar3 = this.aGh.aGg;
            textView = bpVar3.aFL;
            textView.setVisibility(8);
            return;
        }
        bpVar = this.aGh.aGg;
        bpVar2 = this.aGh.aGg;
        eVar = bpVar2.aFY;
        bpVar.f(eVar);
    }
}
