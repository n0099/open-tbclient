package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity cGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cGL = absMsgImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
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
        AbsMsgImageActivity.a aVar;
        NavigationBar navigationBar5;
        int i;
        view2 = this.cGL.agC;
        if (view != view2) {
            if (view == this.cGL.cGx) {
                navigationBar4 = this.cGL.cGy;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cGL.cGz;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cGL.cGz;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cGL.cGw = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cGL.cGw;
                            aVar.execute(new String[0]);
                            this.cGL.cGx.setClickable(false);
                        } else {
                            this.cGL.showToast(this.cGL.getPageContext().getString(u.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cGL.cGC;
            if (z) {
                navigationBar = this.cGL.cGy;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cGL.cGy;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cGL.cGz;
                    multiImageView2.zC();
                    this.cGL.cGB = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cGL.cGB = new AlphaAnimation(1.0f, 0.0f);
                    this.cGL.cGD = true;
                    multiImageView = this.cGL.cGz;
                    multiImageView.zD();
                }
                alphaAnimation = this.cGL.cGB;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cGL.cGB;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cGL.cGB;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cGL.cGC = false;
                navigationBar2 = this.cGL.cGy;
                alphaAnimation4 = this.cGL.cGB;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cGL.cGy;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cGL.mIndex;
            intent.putExtra("index", i);
            this.cGL.setResult(-1, intent);
            this.cGL.finish();
        }
    }
}
