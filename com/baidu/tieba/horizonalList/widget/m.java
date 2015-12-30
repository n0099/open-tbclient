package com.baidu.tieba.horizonalList.widget;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnTouchListener {
    final /* synthetic */ l bFC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bFC = lVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getPointerCount() > 1 || view.getParent() != null;
    }
}
