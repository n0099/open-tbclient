package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnTouchListener {
    final /* synthetic */ bf aOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bf bfVar) {
        this.aOn = bfVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == com.baidu.tieba.q.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.aOn.aNC;
                com.baidu.tbadk.core.util.ay.c(imageView, com.baidu.tieba.p.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.aOn.aNC;
                com.baidu.tbadk.core.util.ay.c(imageView2, com.baidu.tieba.p.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
