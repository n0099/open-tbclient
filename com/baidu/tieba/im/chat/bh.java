package com.baidu.tieba.im.chat;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnTouchListener {
    final /* synthetic */ MsgleftView bpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsgleftView msgleftView) {
        this.bpg = msgleftView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchType touchType;
        TouchType touchType2;
        touchType = this.bpg.bpe;
        if (touchType.get() && motionEvent.getAction() == 1) {
            this.bpg.bou.onItemViewLongClick(view, 2, this.bpg.apk, 0L);
            touchType2 = this.bpg.bpe;
            touchType2.set(false);
        }
        return false;
    }
}
