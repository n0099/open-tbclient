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
    final /* synthetic */ AbsMsgImageActivity aZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aZl = absMsgImageActivity;
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
        view2 = this.aZl.mBack;
        if (view != view2) {
            frameLayout = this.aZl.aYX;
            if (view == frameLayout) {
                navigationBar4 = this.aZl.aYY;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aZl.aYZ;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aZl.aYZ;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aZl.aYW = new h(this.aZl, currentImageUrl, currentImageData);
                            hVar = this.aZl.aYW;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aZl.aYX;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aZl.showToast(this.aZl.getPageContext().getString(com.baidu.tieba.t.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aZl.aZc;
            if (z) {
                navigationBar = this.aZl.aYY;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aZl.aYY;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aZl.aYZ;
                    multiImageView2.xZ();
                    this.aZl.aZb = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aZl.aZb = new AlphaAnimation(1.0f, 0.0f);
                    this.aZl.aZd = true;
                    multiImageView = this.aZl.aYZ;
                    multiImageView.ya();
                }
                alphaAnimation = this.aZl.aZb;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aZl.aZb;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aZl.aZb;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aZl.aZc = false;
                navigationBar2 = this.aZl.aYY;
                alphaAnimation4 = this.aZl.aZb;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aZl.aYY;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aZl.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aZl.setResult(-1, intent);
            this.aZl.finish();
        }
    }
}
