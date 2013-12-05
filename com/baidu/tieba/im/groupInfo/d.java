package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.view.MultiImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupImageActivity f1744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GroupImageActivity groupImageActivity) {
        this.f1744a = groupImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        FrameLayout frameLayout;
        boolean z;
        NavigationBar navigationBar;
        MultiImageView multiImageView;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        AlphaAnimation alphaAnimation3;
        NavigationBar navigationBar2;
        AlphaAnimation alphaAnimation4;
        NavigationBar navigationBar3;
        MultiImageView multiImageView2;
        NavigationBar navigationBar4;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        h hVar;
        TextView textView;
        ProgressBar progressBar;
        NavigationBar navigationBar5;
        int i;
        imageView = this.f1744a.h;
        if (view == imageView) {
            navigationBar5 = this.f1744a.e;
            if (navigationBar5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f1744a.c;
                intent.putExtra("index", i);
                this.f1744a.setResult(-1, intent);
                this.f1744a.finish();
                return;
            }
            return;
        }
        frameLayout = this.f1744a.g;
        if (view == frameLayout) {
            navigationBar4 = this.f1744a.e;
            if (navigationBar4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f1744a.j;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f1744a.j;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f1744a.d = new h(this.f1744a, currentImageUrl, currentImageData);
                        hVar = this.f1744a.d;
                        hVar.execute(new String[0]);
                        textView = this.f1744a.f;
                        textView.setVisibility(4);
                        progressBar = this.f1744a.f1735a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f1744a.showToast(this.f1744a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f1744a.o;
        if (z) {
            navigationBar = this.f1744a.e;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.f1744a.e;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.f1744a.j;
                multiImageView2.d();
                this.f1744a.n = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f1744a.n = new AlphaAnimation(1.0f, 0.0f);
                this.f1744a.p = true;
                multiImageView = this.f1744a.j;
                multiImageView.e();
            }
            alphaAnimation = this.f1744a.n;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f1744a.n;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f1744a.n;
            alphaAnimation3.setAnimationListener(new e(this));
            this.f1744a.o = false;
            navigationBar2 = this.f1744a.e;
            alphaAnimation4 = this.f1744a.n;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
