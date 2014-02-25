package com.baidu.tieba.im.chat;

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
public class bk implements View.OnClickListener {
    final /* synthetic */ MsgImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgImageActivity msgImageActivity) {
        this.a = msgImageActivity;
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
        bp bpVar;
        TextView textView;
        ProgressBar progressBar;
        NavigationBar navigationBar5;
        int i;
        imageView = this.a.f;
        if (view != imageView) {
            frameLayout = this.a.g;
            if (view == frameLayout) {
                navigationBar4 = this.a.i;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.a.j;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.a.j;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.a.d = new bp(this.a, currentImageUrl, currentImageData);
                            bpVar = this.a.d;
                            bpVar.execute(new String[0]);
                            textView = this.a.e;
                            textView.setVisibility(4);
                            progressBar = this.a.a;
                            progressBar.setVisibility(0);
                        } else {
                            this.a.showToast(this.a.getString(R.string.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.a.o;
            if (z) {
                navigationBar = this.a.i;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.a.i;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.a.j;
                    multiImageView2.d();
                    this.a.n = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.a.n = new AlphaAnimation(1.0f, 0.0f);
                    this.a.p = true;
                    multiImageView = this.a.j;
                    multiImageView.e();
                }
                alphaAnimation = this.a.n;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.a.n;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.a.n;
                alphaAnimation3.setAnimationListener(new bl(this));
                this.a.o = false;
                navigationBar2 = this.a.i;
                alphaAnimation4 = this.a.n;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.a.i;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.a.c;
            intent.putExtra("index", i);
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
