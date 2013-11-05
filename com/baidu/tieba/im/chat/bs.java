package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bh bhVar) {
        this.f1446a = bhVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.f1446a.L();
        button = this.f1446a.w;
        button.postDelayed(new bt(this), 100L);
    }
}
