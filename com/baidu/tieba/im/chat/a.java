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
    final /* synthetic */ AbsMsgImageActivity aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aWp = absMsgImageActivity;
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
        view2 = this.aWp.mBack;
        if (view != view2) {
            frameLayout = this.aWp.aWc;
            if (view == frameLayout) {
                navigationBar4 = this.aWp.aWd;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aWp.aWe;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aWp.aWe;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aWp.aWb = new h(this.aWp, currentImageUrl, currentImageData);
                            hVar = this.aWp.aWb;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aWp.aWc;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aWp.showToast(this.aWp.getPageContext().getString(com.baidu.tieba.y.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aWp.aWg;
            if (z) {
                navigationBar = this.aWp.aWd;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aWp.aWd;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aWp.aWe;
                    multiImageView2.xg();
                    this.aWp.atw = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aWp.atw = new AlphaAnimation(1.0f, 0.0f);
                    this.aWp.aWh = true;
                    multiImageView = this.aWp.aWe;
                    multiImageView.xh();
                }
                alphaAnimation = this.aWp.atw;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aWp.atw;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aWp.atw;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aWp.aWg = false;
                navigationBar2 = this.aWp.aWd;
                alphaAnimation4 = this.aWp.atw;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aWp.aWd;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aWp.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aWp.setResult(-1, intent);
            this.aWp.finish();
        }
    }
}
