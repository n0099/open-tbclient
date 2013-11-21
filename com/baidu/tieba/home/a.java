package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.f1386a = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        ImageView imageView;
        relativeLayout = this.f1386a.i;
        if (view == relativeLayout) {
            this.f1386a.d();
            return;
        }
        frameLayout = this.f1386a.k;
        if (view == frameLayout) {
            this.f1386a.c();
            return;
        }
        imageView = this.f1386a.j;
        if (view == imageView) {
            this.f1386a.finish();
        }
    }
}
