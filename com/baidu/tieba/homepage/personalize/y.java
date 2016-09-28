package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(m mVar) {
        this.this$0 = mVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.this$0.cFI;
        if (onTouchListener != null) {
            onTouchListener2 = this.this$0.cFI;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.this$0.aMp;
        if (aVar != null) {
            aVar2 = this.this$0.aMp;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
