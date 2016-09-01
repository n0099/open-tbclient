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
    final /* synthetic */ AbsMsgImageActivity cSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cSr = absMsgImageActivity;
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
        view2 = this.cSr.ajw;
        if (view != view2) {
            if (view == this.cSr.cSd) {
                navigationBar4 = this.cSr.cSe;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cSr.cSf;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cSr.cSf;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cSr.cSc = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cSr.cSc;
                            aVar.execute(new String[0]);
                            this.cSr.cSd.setClickable(false);
                        } else {
                            this.cSr.showToast(this.cSr.getPageContext().getString(t.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cSr.cSi;
            if (z) {
                navigationBar = this.cSr.cSe;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cSr.cSe;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cSr.cSf;
                    multiImageView2.AR();
                    this.cSr.cSh = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cSr.cSh = new AlphaAnimation(1.0f, 0.0f);
                    this.cSr.cSj = true;
                    multiImageView = this.cSr.cSf;
                    multiImageView.AS();
                }
                alphaAnimation = this.cSr.cSh;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cSr.cSh;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cSr.cSh;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cSr.cSi = false;
                navigationBar2 = this.cSr.cSe;
                alphaAnimation4 = this.cSr.cSh;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cSr.cSe;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cSr.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cSr.setResult(-1, intent);
            this.cSr.finish();
        }
    }
}
