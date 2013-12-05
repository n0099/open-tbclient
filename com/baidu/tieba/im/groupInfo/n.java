package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f1754a = mVar;
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.f1754a.S;
            textView2.setVisibility(0);
            return;
        }
        textView = this.f1754a.S;
        textView.setVisibility(8);
    }
}
