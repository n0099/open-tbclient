package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnTouchListener {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bp bpVar) {
        this.aGj = bpVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == com.baidu.tieba.w.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.aGj.aFm;
                com.baidu.tbadk.core.util.bc.c(imageView, com.baidu.tieba.v.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.aGj.aFm;
                com.baidu.tbadk.core.util.bc.c(imageView2, com.baidu.tieba.v.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
