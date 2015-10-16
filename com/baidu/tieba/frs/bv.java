package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnTouchListener {
    final /* synthetic */ bs aXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bs bsVar) {
        this.aXd = bsVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == i.f.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.aXd.aWB;
                com.baidu.tbadk.core.util.an.c(imageView, i.e.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.aXd.aWB;
                com.baidu.tbadk.core.util.an.c(imageView2, i.e.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
