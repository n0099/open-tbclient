package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements View.OnTouchListener {
    final /* synthetic */ cg bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cg cgVar) {
        this.bhg = cgVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == n.g.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.bhg.bgE;
                com.baidu.tbadk.core.util.as.c(imageView, n.f.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.bhg.bgE;
                com.baidu.tbadk.core.util.as.c(imageView2, n.f.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
