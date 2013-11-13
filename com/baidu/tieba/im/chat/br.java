package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bg bgVar) {
        this.f1538a = bgVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.f1538a.L();
        button = this.f1538a.x;
        button.postDelayed(new bs(this), 100L);
    }
}
