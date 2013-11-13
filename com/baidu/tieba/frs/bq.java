package com.baidu.tieba.frs;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bn bnVar) {
        this.f1342a = bnVar;
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
                i = this.f1342a.y;
                if (i == 1) {
                    imageView2 = this.f1342a.k;
                    imageView2.setImageResource(R.drawable.pic_fresh_n_1);
                } else {
                    imageView = this.f1342a.k;
                    imageView.setImageResource(R.drawable.pic_fresh_n);
                }
            }
            if (motionEvent.getAction() == 0) {
                i2 = this.f1342a.y;
                if (i2 == 1) {
                    imageView4 = this.f1342a.k;
                    imageView4.setImageResource(R.drawable.pic_fresh_s_1);
                    return false;
                }
                imageView3 = this.f1342a.k;
                imageView3.setImageResource(R.drawable.pic_fresh_s);
                return false;
            }
            return false;
        }
        return false;
    }
}
