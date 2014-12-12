package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements View.OnTouchListener {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bq bqVar) {
        this.aFg = bqVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == com.baidu.tieba.w.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.aFg.aEk;
                com.baidu.tbadk.core.util.ax.c(imageView, com.baidu.tieba.v.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.aFg.aEk;
                com.baidu.tbadk.core.util.ax.c(imageView2, com.baidu.tieba.v.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
