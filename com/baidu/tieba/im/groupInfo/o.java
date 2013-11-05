package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f1610a = nVar;
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.f1610a.R;
            textView2.setVisibility(0);
            return;
        }
        textView = this.f1610a.R;
        textView.setVisibility(8);
    }
}
