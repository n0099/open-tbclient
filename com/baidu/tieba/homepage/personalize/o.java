package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnTouchListener {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.ctz = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.ctz.ctf;
        if (onTouchListener != null) {
            onTouchListener2 = this.ctz.ctf;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.ctz.aLl;
        if (aVar != null) {
            aVar2 = this.ctz.aLl;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
