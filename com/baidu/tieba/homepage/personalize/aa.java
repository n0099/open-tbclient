package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnTouchListener {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(o oVar) {
        this.this$0 = oVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.e.a aVar;
        com.baidu.tieba.e.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.this$0.cBm;
        if (onTouchListener != null) {
            onTouchListener2 = this.this$0.cBm;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.this$0.chV;
        if (aVar != null) {
            aVar2 = this.this$0.chV;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
