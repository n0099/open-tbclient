package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnTouchListener {
    final /* synthetic */ bu aDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bu buVar) {
        this.aDt = buVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == com.baidu.tieba.v.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.aDt.aCz;
                com.baidu.tbadk.core.util.aw.c(imageView, com.baidu.tieba.u.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.aDt.aCz;
                com.baidu.tbadk.core.util.aw.c(imageView2, com.baidu.tieba.u.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
