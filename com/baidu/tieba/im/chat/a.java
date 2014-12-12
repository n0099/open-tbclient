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
    final /* synthetic */ AbsMsgImageActivity aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.aQe = absMsgImageActivity;
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
        view2 = this.aQe.mBack;
        if (view != view2) {
            frameLayout = this.aQe.aPS;
            if (view == frameLayout) {
                navigationBar4 = this.aQe.aPT;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.aQe.aPU;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.aQe.aPU;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.aQe.aPR = new h(this.aQe, currentImageUrl, currentImageData);
                            hVar = this.aQe.aPR;
                            hVar.execute(new String[0]);
                            frameLayout2 = this.aQe.aPS;
                            frameLayout2.setClickable(false);
                        } else {
                            this.aQe.showToast(this.aQe.getPageContext().getString(com.baidu.tieba.z.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.aQe.aPW;
            if (z) {
                navigationBar = this.aQe.aPT;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.aQe.aPT;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.aQe.aPU;
                    multiImageView2.tB();
                    this.aQe.akw = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.aQe.akw = new AlphaAnimation(1.0f, 0.0f);
                    this.aQe.aPX = true;
                    multiImageView = this.aQe.aPU;
                    multiImageView.tC();
                }
                alphaAnimation = this.aQe.akw;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.aQe.akw;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.aQe.akw;
                alphaAnimation3.setAnimationListener(new b(this));
                this.aQe.aPW = false;
                navigationBar2 = this.aQe.aPT;
                alphaAnimation4 = this.aQe.akw;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.aQe.aPT;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.aQe.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.aQe.setResult(-1, intent);
            this.aQe.finish();
        }
    }
}
