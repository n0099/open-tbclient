package com.baidu.tbadk.vcode;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnTouchListener {
    final /* synthetic */ CommonVcodeActivity aEz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CommonVcodeActivity commonVcodeActivity) {
        this.aEz = commonVcodeActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
    }
}
