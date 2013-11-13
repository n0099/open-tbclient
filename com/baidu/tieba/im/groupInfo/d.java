package com.baidu.tieba.im.groupInfo;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.view.MultiImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupImageActivity f1686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GroupImageActivity groupImageActivity) {
        this.f1686a = groupImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        Button button2;
        boolean z;
        LinearLayout linearLayout;
        MultiImageView multiImageView;
        AlphaAnimation alphaAnimation;
        AlphaAnimation alphaAnimation2;
        AlphaAnimation alphaAnimation3;
        LinearLayout linearLayout2;
        AlphaAnimation alphaAnimation4;
        LinearLayout linearLayout3;
        MultiImageView multiImageView2;
        LinearLayout linearLayout4;
        MultiImageView multiImageView3;
        MultiImageView multiImageView4;
        h hVar;
        Button button3;
        ProgressBar progressBar;
        LinearLayout linearLayout5;
        int i;
        button = this.f1686a.f;
        if (view == button) {
            linearLayout5 = this.f1686a.h;
            if (linearLayout5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f1686a.c;
                intent.putExtra("index", i);
                this.f1686a.setResult(-1, intent);
                this.f1686a.finish();
                return;
            }
            return;
        }
        button2 = this.f1686a.e;
        if (view == button2) {
            linearLayout4 = this.f1686a.h;
            if (linearLayout4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f1686a.i;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f1686a.i;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f1686a.d = new h(this.f1686a, currentImageUrl, currentImageData);
                        hVar = this.f1686a.d;
                        hVar.execute(new String[0]);
                        button3 = this.f1686a.e;
                        button3.setVisibility(4);
                        progressBar = this.f1686a.f1677a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f1686a.showToast(this.f1686a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f1686a.n;
        if (z) {
            linearLayout = this.f1686a.h;
            if (linearLayout.getVisibility() != 0) {
                linearLayout3 = this.f1686a.h;
                linearLayout3.setVisibility(0);
                multiImageView2 = this.f1686a.i;
                multiImageView2.d();
                this.f1686a.m = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f1686a.m = new AlphaAnimation(1.0f, 0.0f);
                this.f1686a.o = true;
                multiImageView = this.f1686a.i;
                multiImageView.e();
            }
            alphaAnimation = this.f1686a.m;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f1686a.m;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f1686a.m;
            alphaAnimation3.setAnimationListener(new e(this));
            this.f1686a.n = false;
            linearLayout2 = this.f1686a.h;
            alphaAnimation4 = this.f1686a.m;
            linearLayout2.startAnimation(alphaAnimation4);
        }
    }
}
