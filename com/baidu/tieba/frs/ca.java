package com.baidu.tieba.frs;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements com.baidu.tbadk.coreExtra.view.r {
    final /* synthetic */ bz aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.aFh = bzVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.r
    public void onVisibleChange(int i) {
        bq bqVar;
        bq bqVar2;
        com.baidu.tieba.tbadkCore.e eVar;
        bq bqVar3;
        TextView textView;
        if (i == 0) {
            bqVar3 = this.aFh.aFg;
            textView = bqVar3.aEL;
            textView.setVisibility(8);
            return;
        }
        bqVar = this.aFh.aFg;
        bqVar2 = this.aFh.aFg;
        eVar = bqVar2.aEY;
        bqVar.f(eVar);
    }
}
