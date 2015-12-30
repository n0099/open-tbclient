package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity bKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bKg = absMsgImageActivity;
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
        view2 = this.bKg.mBack;
        if (view != view2) {
            if (view == this.bKg.bJS) {
                navigationBar4 = this.bKg.bJT;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bKg.bJU;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bKg.bJU;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bKg.bJR = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bKg.bJR;
                            aVar.execute(new String[0]);
                            this.bKg.bJS.setClickable(false);
                        } else {
                            this.bKg.showToast(this.bKg.getPageContext().getString(n.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bKg.bJX;
            if (z) {
                navigationBar = this.bKg.bJT;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bKg.bJT;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bKg.bJU;
                    multiImageView2.zJ();
                    this.bKg.bJW = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bKg.bJW = new AlphaAnimation(1.0f, 0.0f);
                    this.bKg.bJY = true;
                    multiImageView = this.bKg.bJU;
                    multiImageView.zK();
                }
                alphaAnimation = this.bKg.bJW;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bKg.bJW;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bKg.bJW;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bKg.bJX = false;
                navigationBar2 = this.bKg.bJT;
                alphaAnimation4 = this.bKg.bJW;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bKg.bJT;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bKg.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bKg.setResult(-1, intent);
            this.bKg.finish();
        }
    }
}
