package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnTouchListener {
    final /* synthetic */ bi aXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar) {
        this.aXy = biVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == i.f.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.aXy.aWW;
                com.baidu.tbadk.core.util.al.c(imageView, i.e.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.aXy.aWW;
                com.baidu.tbadk.core.util.al.c(imageView2, i.e.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
