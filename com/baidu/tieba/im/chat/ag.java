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
public class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(MsgImageActivity msgImageActivity) {
        this.f1540a = msgImageActivity;
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
        al alVar;
        TextView textView;
        ProgressBar progressBar;
        NavigationBar navigationBar5;
        int i;
        imageView = this.f1540a.f;
        if (view == imageView) {
            navigationBar5 = this.f1540a.i;
            if (navigationBar5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f1540a.c;
                intent.putExtra("index", i);
                this.f1540a.setResult(-1, intent);
                this.f1540a.finish();
                return;
            }
            return;
        }
        frameLayout = this.f1540a.g;
        if (view == frameLayout) {
            navigationBar4 = this.f1540a.i;
            if (navigationBar4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f1540a.j;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f1540a.j;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f1540a.d = new al(this.f1540a, currentImageUrl, currentImageData);
                        alVar = this.f1540a.d;
                        alVar.execute(new String[0]);
                        textView = this.f1540a.e;
                        textView.setVisibility(4);
                        progressBar = this.f1540a.f1533a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f1540a.showToast(this.f1540a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f1540a.o;
        if (z) {
            navigationBar = this.f1540a.i;
            if (navigationBar.getVisibility() != 0) {
                navigationBar3 = this.f1540a.i;
                navigationBar3.setVisibility(0);
                multiImageView2 = this.f1540a.j;
                multiImageView2.d();
                this.f1540a.n = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f1540a.n = new AlphaAnimation(1.0f, 0.0f);
                this.f1540a.p = true;
                multiImageView = this.f1540a.j;
                multiImageView.e();
            }
            alphaAnimation = this.f1540a.n;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f1540a.n;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f1540a.n;
            alphaAnimation3.setAnimationListener(new ah(this));
            this.f1540a.o = false;
            navigationBar2 = this.f1540a.i;
            alphaAnimation4 = this.f1540a.n;
            navigationBar2.startAnimation(alphaAnimation4);
        }
    }
}
