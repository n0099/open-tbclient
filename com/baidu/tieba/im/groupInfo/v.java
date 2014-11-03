package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.coreExtra.view.i {
    final /* synthetic */ t bbH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.bbH = tVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.i
    public void ak(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.bbH.bbz;
            textView2.setVisibility(0);
            return;
        }
        textView = this.bbH.bbz;
        textView.setVisibility(8);
    }
}
