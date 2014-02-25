package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnTouchListener {
    final /* synthetic */ br a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.a = brVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        int i2;
        ImageView imageView3;
        ImageView imageView4;
        if (view.getId() == R.id.refresh_layout) {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4 || motionEvent.getAction() == 3) {
                i = this.a.z;
                if (i == 1) {
                    imageView2 = this.a.l;
                    imageView2.setImageResource(R.drawable.pic_fresh_n_1);
                } else {
                    imageView = this.a.l;
                    imageView.setImageResource(R.drawable.pic_fresh_n);
                }
            }
            if (motionEvent.getAction() == 0) {
                i2 = this.a.z;
                if (i2 == 1) {
                    imageView4 = this.a.l;
                    imageView4.setImageResource(R.drawable.pic_fresh_s_1);
                    return false;
                }
                imageView3 = this.a.l;
                imageView3.setImageResource(R.drawable.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
