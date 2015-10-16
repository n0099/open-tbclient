package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity bqP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bqP = absMsgImageActivity;
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
        view2 = this.bqP.mBack;
        if (view != view2) {
            if (view == this.bqP.bqB) {
                navigationBar4 = this.bqP.bqC;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bqP.bqD;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bqP.bqD;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bqP.bqA = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bqP.bqA;
                            aVar.execute(new String[0]);
                            this.bqP.bqB.setClickable(false);
                        } else {
                            this.bqP.showToast(this.bqP.getPageContext().getString(i.h.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bqP.bqG;
            if (z) {
                navigationBar = this.bqP.bqC;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bqP.bqC;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bqP.bqD;
                    multiImageView2.yZ();
                    this.bqP.bqF = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bqP.bqF = new AlphaAnimation(1.0f, 0.0f);
                    this.bqP.bqH = true;
                    multiImageView = this.bqP.bqD;
                    multiImageView.za();
                }
                alphaAnimation = this.bqP.bqF;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bqP.bqF;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bqP.bqF;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bqP.bqG = false;
                navigationBar2 = this.bqP.bqC;
                alphaAnimation4 = this.bqP.bqF;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bqP.bqC;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bqP.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bqP.setResult(-1, intent);
            this.bqP.finish();
        }
    }
}
