package com.baidu.tieba.frs;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements com.baidu.tbadk.coreExtra.view.ah {
    final /* synthetic */ bu aDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bu buVar) {
        this.aDD = buVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ah
    public void ct(int i) {
        b bVar;
        TextView textView;
        if (i == 0) {
            textView = this.aDD.aDl;
            textView.setVisibility(8);
            return;
        }
        bu buVar = this.aDD;
        bVar = this.aDD.aDw;
        buVar.i(bVar);
    }
}
