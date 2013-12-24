package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ CreateBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.a = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        ImageView imageView;
        relativeLayout = this.a.i;
        if (view == relativeLayout) {
            this.a.d();
            return;
        }
        frameLayout = this.a.k;
        if (view == frameLayout) {
            this.a.c();
            return;
        }
        imageView = this.a.j;
        if (view == imageView) {
            this.a.finish();
        }
    }
}
