package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bm bmVar) {
        this.f1582a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.f1582a.J();
        button = this.f1582a.x;
        button.postDelayed(new by(this), 100L);
    }
}
