package com.baidu.tieba.frs;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.coreExtra.view.ai {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ai
    public void a(int i) {
        g gVar;
        Button button;
        if (i == 0) {
            button = this.a.ac;
            button.setVisibility(8);
            return;
        }
        ct ctVar = this.a;
        gVar = this.a.al;
        ctVar.a(gVar);
    }
}
