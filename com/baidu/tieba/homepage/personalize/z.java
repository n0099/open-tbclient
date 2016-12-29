package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnTouchListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.this$0.cqr;
        if (onTouchListener != null) {
            onTouchListener2 = this.this$0.cqr;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.this$0.aMe;
        if (aVar != null) {
            aVar2 = this.this$0.aMe;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
