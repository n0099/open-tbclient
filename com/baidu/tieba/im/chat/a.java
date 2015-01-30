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
    final /* synthetic */ AbsMsgImageActivity aRj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aRj = absMsgImageActivity;
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
        view2 = this.aRj.mBack;
        if (view != view2) {
            frameLayout = this.aRj.aQX;
            if (view == frameLayout) {
                navigationBar4 = this.aRj.aQY;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aRj.aQZ;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aRj.aQZ;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aRj.aQW = new h(this.aRj, currentImageUrl, currentImageData);
                            hVar = this.aRj.aQW;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aRj.aQX;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aRj.showToast(this.aRj.getPageContext().getString(com.baidu.tieba.z.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aRj.aRb;
            if (z) {
                navigationBar = this.aRj.aQY;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aRj.aQY;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aRj.aQZ;
                    multiImageView2.tS();
                    this.aRj.akZ = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aRj.akZ = new AlphaAnimation(1.0f, 0.0f);
                    this.aRj.aRc = true;
                    multiImageView = this.aRj.aQZ;
                    multiImageView.tT();
                }
                alphaAnimation = this.aRj.akZ;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aRj.akZ;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aRj.akZ;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aRj.aRb = false;
                navigationBar2 = this.aRj.aQY;
                alphaAnimation4 = this.aRj.akZ;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aRj.aQY;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aRj.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aRj.setResult(-1, intent);
            this.aRj.finish();
        }
    }
}
