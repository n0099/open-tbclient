package com.baidu.tieba.enterForum.d;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    final /* synthetic */ i aYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aYC = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a aVar;
        int i;
        int i2;
        if (motionEvent.getAction() == 0) {
            aVar = this.aYC.aYA;
            i = this.aYC.aYy;
            i2 = this.aYC.aYy;
            aVar.setPadding(i, 0, i2, 0);
        }
        return false;
    }
}
