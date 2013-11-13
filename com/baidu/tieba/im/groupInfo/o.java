package com.baidu.tieba.im.groupInfo;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1697a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f1697a = nVar;
    }

    @Override // com.baidu.tieba.im.groupInfo.c
    public void a(boolean z) {
        TextView textView;
        TextView textView2;
        if (z) {
            textView2 = this.f1697a.Q;
            textView2.setVisibility(0);
            return;
        }
        textView = this.f1697a.Q;
        textView.setVisibility(8);
    }
}
