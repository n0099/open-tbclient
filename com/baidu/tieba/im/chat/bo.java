package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bh bhVar) {
        this.f1442a = bhVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        this.f1442a.M();
        this.f1442a.O();
        button = this.f1442a.m;
        button.postDelayed(new bp(this), 100L);
    }
}
