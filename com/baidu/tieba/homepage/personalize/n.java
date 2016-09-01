package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar) {
        this.this$0 = bVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.e.a aVar;
        com.baidu.tieba.e.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.this$0.cEL;
        if (onTouchListener != null) {
            onTouchListener2 = this.this$0.cEL;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.this$0.aPW;
        if (aVar != null) {
            aVar2 = this.this$0.aPW;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
