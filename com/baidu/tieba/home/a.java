package com.baidu.tieba.home;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
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
        Button button;
        relativeLayout = this.a.f;
        if (view == relativeLayout) {
            this.a.j();
            return;
        }
        frameLayout = this.a.h;
        if (view == frameLayout) {
            this.a.i();
            return;
        }
        button = this.a.g;
        if (view == button) {
            this.a.finish();
        }
    }
}
