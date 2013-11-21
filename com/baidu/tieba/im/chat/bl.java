package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bg bgVar) {
        this.f1523a = bgVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1523a.L();
        this.f1523a.M();
        this.f1523a.N();
        return false;
    }
}
