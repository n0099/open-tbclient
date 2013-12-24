package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.a.T;
            textView2.setVisibility(0);
            return;
        }
        textView = this.a.T;
        textView.setVisibility(8);
    }
}
