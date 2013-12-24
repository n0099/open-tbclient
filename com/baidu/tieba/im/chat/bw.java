package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnTouchListener {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bu buVar) {
        this.a = buVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        aj ajVar;
        if (motionEvent.getAction() == 1) {
            this.a.L();
        } else if (motionEvent.getAction() == 0) {
            this.a.S();
            ajVar = this.a.E;
            if (ajVar.a() == 0) {
                this.a.M();
                this.a.P();
                this.a.R();
                return true;
            }
        }
        return false;
    }
}
