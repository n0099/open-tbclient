package com.baidu.tieba.im.floatwindow;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnTouchListener {
    final /* synthetic */ l aXz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aXz = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = this.aXz.aXy;
        if (z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.aXz.R((int) motionEvent.getX(), (int) motionEvent.getY());
                    break;
                case 1:
                    this.aXz.Nh();
                    break;
                case 2:
                    this.aXz.Q((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                    break;
            }
        }
        return false;
    }
}
