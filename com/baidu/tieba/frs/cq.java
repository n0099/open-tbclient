package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnTouchListener {
    final /* synthetic */ cn bjV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cn cnVar) {
        this.bjV = cnVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == t.g.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.bjV.bjr;
                com.baidu.tbadk.core.util.ar.c(imageView, t.f.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.bjV.bjr;
                com.baidu.tbadk.core.util.ar.c(imageView2, t.f.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
