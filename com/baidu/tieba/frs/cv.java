package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnTouchListener {
    final /* synthetic */ cs bpe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cs csVar) {
        this.bpe = csVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        ImageView imageView2;
        if (view.getId() == t.g.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                imageView = this.bpe.boB;
                com.baidu.tbadk.core.util.at.c(imageView, t.f.pic_fresh_n);
            }
            if (motionEvent.getAction() == 0) {
                imageView2 = this.bpe.boB;
                com.baidu.tbadk.core.util.at.c(imageView2, t.f.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
