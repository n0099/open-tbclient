package com.baidu.tieba.frs;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements com.baidu.tbadk.coreExtra.view.ah {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(bu buVar) {
        this.aDt = buVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ah
    public void ct(int i) {
        b bVar;
        TextView textView;
        if (i == 0) {
            textView = this.aDt.aDb;
            textView.setVisibility(8);
            return;
        }
        bu buVar = this.aDt;
        bVar = this.aDt.aDm;
        buVar.i(bVar);
    }
}
