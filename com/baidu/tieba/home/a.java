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
        relativeLayout = this.a.k;
        if (view != relativeLayout) {
            frameLayout = this.a.m;
            if (view != frameLayout) {
                button = this.a.l;
                if (view == button) {
                    this.a.finish();
                    return;
                }
                return;
            }
            this.a.k();
            return;
        }
        this.a.l();
    }
}
