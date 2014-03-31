package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
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
        relativeLayout = this.a.i;
        if (view != relativeLayout) {
            frameLayout = this.a.j;
            if (view == frameLayout) {
                CreateBarActivity.c(this.a);
                return;
            }
            return;
        }
        CreateBarActivity.g(this.a);
    }
}
