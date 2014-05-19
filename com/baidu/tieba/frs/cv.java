package com.baidu.tieba.frs;

import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements com.baidu.tbadk.coreExtra.view.ag {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ag
    public void a(int i) {
        g gVar;
        Button button;
        if (i == 0) {
            button = this.a.af;
            button.setVisibility(8);
            return;
        }
        cs csVar = this.a;
        gVar = this.a.an;
        csVar.a(gVar);
    }
}
