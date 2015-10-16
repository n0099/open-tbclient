package com.baidu.tieba.enterForum.d;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    final /* synthetic */ i aMZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aMZ = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a aVar;
        int i;
        int i2;
        if (motionEvent.getAction() == 0) {
            aVar = this.aMZ.aMX;
            i = this.aMZ.aMV;
            i2 = this.aMZ.aMV;
            aVar.setPadding(i, 0, i2, 0);
        }
        return false;
    }
}
