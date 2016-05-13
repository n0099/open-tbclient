package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity bYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bYM = absMsgImageActivity;
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
        view2 = this.bYM.afm;
        if (view != view2) {
            if (view == this.bYM.bYy) {
                navigationBar4 = this.bYM.bYz;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bYM.bYA;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bYM.bYA;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bYM.bYx = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bYM.bYx;
                            aVar.execute(new String[0]);
                            this.bYM.bYy.setClickable(false);
                        } else {
                            this.bYM.showToast(this.bYM.getPageContext().getString(t.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bYM.bYD;
            if (z) {
                navigationBar = this.bYM.bYz;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bYM.bYz;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bYM.bYA;
                    multiImageView2.zx();
                    this.bYM.bYC = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bYM.bYC = new AlphaAnimation(1.0f, 0.0f);
                    this.bYM.bYE = true;
                    multiImageView = this.bYM.bYA;
                    multiImageView.zy();
                }
                alphaAnimation = this.bYM.bYC;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bYM.bYC;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bYM.bYC;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bYM.bYD = false;
                navigationBar2 = this.bYM.bYz;
                alphaAnimation4 = this.bYM.bYC;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bYM.bYz;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bYM.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bYM.setResult(-1, intent);
            this.bYM.finish();
        }
    }
}
