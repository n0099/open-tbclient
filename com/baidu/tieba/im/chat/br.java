package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1576a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bm bmVar) {
        this.f1576a = bmVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f1576a.J();
        this.f1576a.K();
        this.f1576a.L();
        return false;
    }
}
