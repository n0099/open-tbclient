package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity cEF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cEF = absMsgImageActivity;
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
        view2 = this.cEF.ajr;
        if (view != view2) {
            if (view == this.cEF.cEr) {
                navigationBar4 = this.cEF.cEs;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cEF.cEt;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cEF.cEt;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cEF.cEq = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cEF.cEq;
                            aVar.execute(new String[0]);
                            this.cEF.cEr.setClickable(false);
                        } else {
                            this.cEF.showToast(this.cEF.getPageContext().getString(r.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cEF.cEw;
            if (z) {
                navigationBar = this.cEF.cEs;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cEF.cEs;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cEF.cEt;
                    multiImageView2.AO();
                    this.cEF.cEv = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cEF.cEv = new AlphaAnimation(1.0f, 0.0f);
                    this.cEF.cEx = true;
                    multiImageView = this.cEF.cEt;
                    multiImageView.AP();
                }
                alphaAnimation = this.cEF.cEv;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cEF.cEv;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cEF.cEv;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cEF.cEw = false;
                navigationBar2 = this.cEF.cEs;
                alphaAnimation4 = this.cEF.cEv;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cEF.cEs;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cEF.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cEF.setResult(-1, intent);
            this.cEF.finish();
        }
    }
}
