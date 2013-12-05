package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(MsgleftView msgleftView) {
        this.f1551a = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.f1551a.r;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.f1551a.d.b(view, 2, this.f1551a.f, 0L);
            touchType2 = this.f1551a.r;
            touchType2.set(false);
        }
        return false;
    }
}
