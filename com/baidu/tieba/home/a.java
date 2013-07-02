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
        relativeLayout = this.a.k;
        if (view != relativeLayout) {
            frameLayout = this.a.m;
            if (view != frameLayout) {
                imageView = this.a.l;
                if (view == imageView) {
                    this.a.finish();
                    return;
                }
                return;
            }
            this.a.d();
            return;
        }
        this.a.m();
    }
}
