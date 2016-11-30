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
    final /* synthetic */ AbsMsgImageActivity cZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cZt = absMsgImageActivity;
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
        view2 = this.cZt.ajQ;
        if (view != view2) {
            if (view == this.cZt.cZf) {
                navigationBar4 = this.cZt.cZg;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cZt.cZh;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cZt.cZh;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cZt.cZe = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cZt.cZe;
                            aVar.execute(new String[0]);
                            this.cZt.cZf.setClickable(false);
                        } else {
                            this.cZt.showToast(this.cZt.getPageContext().getString(r.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cZt.cZk;
            if (z) {
                navigationBar = this.cZt.cZg;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cZt.cZg;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cZt.cZh;
                    multiImageView2.Bb();
                    this.cZt.cZj = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cZt.cZj = new AlphaAnimation(1.0f, 0.0f);
                    this.cZt.cZl = true;
                    multiImageView = this.cZt.cZh;
                    multiImageView.Bc();
                }
                alphaAnimation = this.cZt.cZj;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cZt.cZj;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cZt.cZj;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cZt.cZk = false;
                navigationBar2 = this.cZt.cZg;
                alphaAnimation4 = this.cZt.cZj;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cZt.cZg;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cZt.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cZt.setResult(-1, intent);
            this.cZt.finish();
        }
    }
}
