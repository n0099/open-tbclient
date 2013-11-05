package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1437a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bh bhVar) {
        this.f1437a = bhVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ab abVar;
        if (motionEvent.getAction() == 1) {
            this.f1437a.M();
        } else if (motionEvent.getAction() == 0) {
            this.f1437a.S();
            abVar = this.f1437a.D;
            if (abVar.a() == 0) {
                this.f1437a.N();
                this.f1437a.Q();
                return true;
            }
        }
        return false;
    }
}
