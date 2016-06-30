package com.baidu.tieba.homepage.personalize;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.cqR = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener;
        com.baidu.tieba.d.a aVar;
        com.baidu.tieba.d.a aVar2;
        View.OnTouchListener onTouchListener2;
        onTouchListener = this.cqR.cqA;
        if (onTouchListener != null) {
            onTouchListener2 = this.cqR.cqA;
            onTouchListener2.onTouch(view, motionEvent);
        }
        aVar = this.cqR.aKs;
        if (aVar != null) {
            aVar2 = this.cqR.aKs;
            aVar2.onTouchEvent(motionEvent);
            return false;
        }
        return false;
    }
}
