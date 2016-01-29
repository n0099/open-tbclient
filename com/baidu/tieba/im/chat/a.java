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
    final /* synthetic */ AbsMsgImageActivity bNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bNP = absMsgImageActivity;
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
        view2 = this.bNP.ajk;
        if (view != view2) {
            if (view == this.bNP.bNB) {
                navigationBar4 = this.bNP.bNC;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bNP.bND;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bNP.bND;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bNP.bNA = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bNP.bNA;
                            aVar.execute(new String[0]);
                            this.bNP.bNB.setClickable(false);
                        } else {
                            this.bNP.showToast(this.bNP.getPageContext().getString(t.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bNP.bNG;
            if (z) {
                navigationBar = this.bNP.bNC;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bNP.bNC;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bNP.bND;
                    multiImageView2.AZ();
                    this.bNP.bNF = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bNP.bNF = new AlphaAnimation(1.0f, 0.0f);
                    this.bNP.bNH = true;
                    multiImageView = this.bNP.bND;
                    multiImageView.Ba();
                }
                alphaAnimation = this.bNP.bNF;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bNP.bNF;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bNP.bNF;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bNP.bNG = false;
                navigationBar2 = this.bNP.bNC;
                alphaAnimation4 = this.bNP.bNF;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bNP.bNC;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bNP.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bNP.setResult(-1, intent);
            this.bNP.finish();
        }
    }
}
