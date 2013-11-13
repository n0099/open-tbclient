package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bg bgVar) {
        this.f1532a = bgVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1532a.L();
        this.f1532a.M();
        this.f1532a.N();
        return false;
    }
}
