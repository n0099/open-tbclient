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
    final /* synthetic */ AbsMsgImageActivity aWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aWF = absMsgImageActivity;
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
        view2 = this.aWF.mBack;
        if (view != view2) {
            frameLayout = this.aWF.aWs;
            if (view == frameLayout) {
                navigationBar4 = this.aWF.aWt;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aWF.aWu;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aWF.aWu;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aWF.aWr = new h(this.aWF, currentImageUrl, currentImageData);
                            hVar = this.aWF.aWr;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aWF.aWs;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aWF.showToast(this.aWF.getPageContext().getString(com.baidu.tieba.y.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aWF.aWw;
            if (z) {
                navigationBar = this.aWF.aWt;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aWF.aWt;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aWF.aWu;
                    multiImageView2.xm();
                    this.aWF.atE = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aWF.atE = new AlphaAnimation(1.0f, 0.0f);
                    this.aWF.aWx = true;
                    multiImageView = this.aWF.aWu;
                    multiImageView.xn();
                }
                alphaAnimation = this.aWF.atE;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aWF.atE;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aWF.atE;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aWF.aWw = false;
                navigationBar2 = this.aWF.aWt;
                alphaAnimation4 = this.aWF.atE;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aWF.aWt;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aWF.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aWF.setResult(-1, intent);
            this.aWF.finish();
        }
    }
}
