package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements com.baidu.tbadk.coreExtra.view.i {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.a = rVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.i
    public final void a(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.a.ac;
            textView2.setVisibility(0);
            return;
        }
        textView = this.a.ac;
        textView.setVisibility(8);
    }
}
