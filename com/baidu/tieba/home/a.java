package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.f1326a = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        ImageView imageView;
        relativeLayout = this.f1326a.k;
        if (view == relativeLayout) {
            this.f1326a.e();
            return;
        }
        frameLayout = this.f1326a.m;
        if (view == frameLayout) {
            this.f1326a.d();
            return;
        }
        imageView = this.f1326a.l;
        if (view == imageView) {
            this.f1326a.finish();
        }
    }
}
