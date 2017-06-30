package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnTouchListener {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(x xVar) {
        this.this$0 = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.e.a aVar;
        com.baidu.tieba.e.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.this$0.cJi;
        if (onTouchListener != null) {
            onTouchListener2 = this.this$0.cJi;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.this$0.cpW;
        if (aVar != null) {
            aVar2 = this.this$0.cpW;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
