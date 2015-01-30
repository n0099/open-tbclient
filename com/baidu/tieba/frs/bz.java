package com.baidu.tieba.frs;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ by aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar) {
        this.aGk = byVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void onVisibleChange(int i) {
        bp bpVar;
        bp bpVar2;
        com.baidu.tieba.tbadkCore.e eVar;
        bp bpVar3;
        TextView textView;
        if (i == 0) {
            bpVar3 = this.aGk.aGj;
            textView = bpVar3.aFO;
            textView.setVisibility(8);
            return;
        }
        bpVar = this.aGk.aGj;
        bpVar2 = this.aGk.aGj;
        eVar = bpVar2.aGb;
        bpVar.f(eVar);
    }
}
