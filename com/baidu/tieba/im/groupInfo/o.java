package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements c {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tieba.im.groupInfo.c
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
