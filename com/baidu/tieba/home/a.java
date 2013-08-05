package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.f1112a = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        ImageView imageView;
        relativeLayout = this.f1112a.k;
        if (view != relativeLayout) {
            frameLayout = this.f1112a.m;
            if (view != frameLayout) {
                imageView = this.f1112a.l;
                if (view == imageView) {
                    this.f1112a.finish();
                    return;
                }
                return;
            }
            this.f1112a.d();
            return;
        }
        this.f1112a.k();
    }
}
