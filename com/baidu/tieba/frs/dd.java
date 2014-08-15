package com.baidu.tieba.frs;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements com.baidu.tbadk.coreExtra.view.ai {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ai
    public void a(int i) {
        g gVar;
        Button button;
        if (i == 0) {
            button = this.a.ae;
            button.setVisibility(8);
            return;
        }
        cu cuVar = this.a;
        gVar = this.a.aq;
        cuVar.a(gVar);
    }
}
