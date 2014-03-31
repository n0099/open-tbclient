package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cn implements View.OnTouchListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        int i2;
        ImageView imageView3;
        ImageView imageView4;
        if (view.getId() == com.baidu.tieba.a.h.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                i = this.a.M;
                if (i == 1) {
                    imageView2 = this.a.o;
                    imageView2.setImageResource(com.baidu.tieba.a.g.pic_fresh_n_1);
                } else {
                    imageView = this.a.o;
                    imageView.setImageResource(com.baidu.tieba.a.g.pic_fresh_n);
                }
            }
            if (motionEvent.getAction() == 0) {
                i2 = this.a.M;
                if (i2 == 1) {
                    imageView4 = this.a.o;
                    imageView4.setImageResource(com.baidu.tieba.a.g.pic_fresh_s_1);
                    return false;
                }
                imageView3 = this.a.o;
                imageView3.setImageResource(com.baidu.tieba.a.g.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
