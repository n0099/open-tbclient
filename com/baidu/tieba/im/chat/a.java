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
    final /* synthetic */ AbsMsgImageActivity aZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aZm = absMsgImageActivity;
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
        view2 = this.aZm.mBack;
        if (view != view2) {
            frameLayout = this.aZm.aYY;
            if (view == frameLayout) {
                navigationBar4 = this.aZm.aYZ;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aZm.aZa;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aZm.aZa;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aZm.aYX = new h(this.aZm, currentImageUrl, currentImageData);
                            hVar = this.aZm.aYX;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aZm.aYY;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aZm.showToast(this.aZm.getPageContext().getString(com.baidu.tieba.t.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aZm.aZd;
            if (z) {
                navigationBar = this.aZm.aYZ;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aZm.aYZ;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aZm.aZa;
                    multiImageView2.ya();
                    this.aZm.aZc = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aZm.aZc = new AlphaAnimation(1.0f, 0.0f);
                    this.aZm.aZe = true;
                    multiImageView = this.aZm.aZa;
                    multiImageView.yb();
                }
                alphaAnimation = this.aZm.aZc;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aZm.aZc;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aZm.aZc;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aZm.aZd = false;
                navigationBar2 = this.aZm.aYZ;
                alphaAnimation4 = this.aZm.aZc;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aZm.aYZ;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aZm.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aZm.setResult(-1, intent);
            this.aZm.finish();
        }
    }
}
