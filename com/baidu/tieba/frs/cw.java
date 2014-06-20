package com.baidu.tieba.frs;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements com.baidu.tbadk.coreExtra.view.ag {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ag
    public void a(int i) {
        g gVar;
        Button button;
        if (i == 0) {
            button = this.a.ae;
            button.setVisibility(8);
            return;
        }
        ct ctVar = this.a;
        gVar = this.a.am;
        ctVar.a(gVar);
    }
}
