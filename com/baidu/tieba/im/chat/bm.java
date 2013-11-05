package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bh bhVar) {
        this.f1440a = bhVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1440a.L();
        this.f1440a.M();
        this.f1440a.N();
        return false;
    }
}
