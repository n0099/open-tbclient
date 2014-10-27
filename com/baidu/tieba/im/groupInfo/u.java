package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.coreExtra.view.i {
    final /* synthetic */ s bbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.bbt = sVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.i
    public void ak(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.bbt.bbl;
            textView2.setVisibility(0);
            return;
        }
        textView = this.bbt.bbl;
        textView.setVisibility(8);
    }
}
