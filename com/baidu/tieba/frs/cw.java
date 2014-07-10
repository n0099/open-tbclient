package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnTouchListener {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ct ctVar) {
        this.a = ctVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        int i2;
        ImageView imageView3;
        ImageView imageView4;
        if (view.getId() == com.baidu.tieba.v.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                i = this.a.L;
                if (i == 1) {
                    imageView2 = this.a.n;
                    imageView2.setImageResource(com.baidu.tieba.u.pic_fresh_n_1);
                } else {
                    imageView = this.a.n;
                    imageView.setImageResource(com.baidu.tieba.u.pic_fresh_n);
                }
            }
            if (motionEvent.getAction() == 0) {
                i2 = this.a.L;
                if (i2 == 1) {
                    imageView4 = this.a.n;
                    imageView4.setImageResource(com.baidu.tieba.u.pic_fresh_s_1);
                    return false;
                }
                imageView3 = this.a.n;
                imageView3.setImageResource(com.baidu.tieba.u.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
