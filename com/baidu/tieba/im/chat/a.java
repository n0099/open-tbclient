package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aRi = absMsgImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
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
        FrameLayout frameLayout2;
        NavigationBar navigationBar5;
        int i;
        view2 = this.aRi.mBack;
        if (view != view2) {
            frameLayout = this.aRi.aQW;
            if (view == frameLayout) {
                navigationBar4 = this.aRi.aQX;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aRi.aQY;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aRi.aQY;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aRi.aQV = new h(this.aRi, currentImageUrl, currentImageData);
                            hVar = this.aRi.aQV;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aRi.aQW;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aRi.showToast(this.aRi.getPageContext().getString(com.baidu.tieba.z.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aRi.aRa;
            if (z) {
                navigationBar = this.aRi.aQX;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aRi.aQX;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aRi.aQY;
                    multiImageView2.tM();
                    this.aRi.akW = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aRi.akW = new AlphaAnimation(1.0f, 0.0f);
                    this.aRi.aRb = true;
                    multiImageView = this.aRi.aQY;
                    multiImageView.tN();
                }
                alphaAnimation = this.aRi.akW;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aRi.akW;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aRi.akW;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aRi.aRa = false;
                navigationBar2 = this.aRi.aQX;
                alphaAnimation4 = this.aRi.akW;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aRi.aQX;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aRi.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aRi.setResult(-1, intent);
            this.aRi.finish();
        }
    }
}
