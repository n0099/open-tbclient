package com.baidu.tieba.frs;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements com.baidu.tbadk.coreExtra.view.ai {
    final /* synthetic */ cv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ai
    public void a(int i) {
        g gVar;
        Button button;
        if (i == 0) {
            button = this.a.af;
            button.setVisibility(8);
            return;
        }
        cv cvVar = this.a;
        gVar = this.a.as;
        cvVar.a(gVar);
    }
}
