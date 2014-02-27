package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
final class a implements View.OnClickListener {
    final /* synthetic */ CreateBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.a = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        ImageView imageView;
        relativeLayout = this.a.i;
        if (view != relativeLayout) {
            frameLayout = this.a.k;
            if (view != frameLayout) {
                imageView = this.a.j;
                if (view == imageView) {
                    this.a.finish();
                    return;
                }
                return;
            }
            CreateBarActivity.c(this.a);
            return;
        }
        CreateBarActivity.g(this.a);
    }
}
