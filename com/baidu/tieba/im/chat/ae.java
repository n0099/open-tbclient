package com.baidu.tieba.im.chat;

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
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgImageActivity f1407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsgImageActivity msgImageActivity) {
        this.f1407a = msgImageActivity;
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
        aj ajVar;
        Button button3;
        ProgressBar progressBar;
        LinearLayout linearLayout5;
        int i;
        button = this.f1407a.f;
        if (view == button) {
            linearLayout5 = this.f1407a.j;
            if (linearLayout5.getVisibility() != 8) {
                Intent intent = new Intent();
                i = this.f1407a.c;
                intent.putExtra("index", i);
                this.f1407a.setResult(-1, intent);
                this.f1407a.finish();
                return;
            }
            return;
        }
        button2 = this.f1407a.e;
        if (view == button2) {
            linearLayout4 = this.f1407a.j;
            if (linearLayout4.getVisibility() != 8) {
                try {
                    multiImageView3 = this.f1407a.k;
                    byte[] currentImageData = multiImageView3.getCurrentImageData();
                    if (currentImageData != null) {
                        multiImageView4 = this.f1407a.k;
                        String currentImageUrl = multiImageView4.getCurrentImageUrl();
                        this.f1407a.d = new aj(this.f1407a, currentImageUrl, currentImageData);
                        ajVar = this.f1407a.d;
                        ajVar.execute(new String[0]);
                        button3 = this.f1407a.e;
                        button3.setVisibility(4);
                        progressBar = this.f1407a.f1400a;
                        progressBar.setVisibility(0);
                    } else {
                        this.f1407a.a(this.f1407a.getString(R.string.no_data));
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            }
            return;
        }
        z = this.f1407a.p;
        if (z) {
            linearLayout = this.f1407a.j;
            if (linearLayout.getVisibility() != 0) {
                linearLayout3 = this.f1407a.j;
                linearLayout3.setVisibility(0);
                multiImageView2 = this.f1407a.k;
                multiImageView2.d();
                this.f1407a.o = new AlphaAnimation(0.0f, 1.0f);
            } else {
                this.f1407a.o = new AlphaAnimation(1.0f, 0.0f);
                this.f1407a.q = true;
                multiImageView = this.f1407a.k;
                multiImageView.e();
            }
            alphaAnimation = this.f1407a.o;
            alphaAnimation.setDuration(300L);
            alphaAnimation2 = this.f1407a.o;
            alphaAnimation2.setFillAfter(true);
            alphaAnimation3 = this.f1407a.o;
            alphaAnimation3.setAnimationListener(new af(this));
            this.f1407a.p = false;
            linearLayout2 = this.f1407a.j;
            alphaAnimation4 = this.f1407a.o;
            linearLayout2.startAnimation(alphaAnimation4);
        }
    }
}
