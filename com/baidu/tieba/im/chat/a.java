package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity cMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cMz = absMsgImageActivity;
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
        view2 = this.cMz.aom;
        if (view != view2) {
            if (view == this.cMz.cMl) {
                navigationBar4 = this.cMz.cMm;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cMz.cMn;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cMz.cMn;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cMz.cMk = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cMz.cMk;
                            aVar.execute(new String[0]);
                            this.cMz.cMl.setClickable(false);
                        } else {
                            this.cMz.showToast(this.cMz.getPageContext().getString(w.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cMz.cMq;
            if (z) {
                navigationBar = this.cMz.cMm;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cMz.cMm;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cMz.cMn;
                    multiImageView2.BB();
                    this.cMz.cMp = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cMz.cMp = new AlphaAnimation(1.0f, 0.0f);
                    this.cMz.cMr = true;
                    multiImageView = this.cMz.cMn;
                    multiImageView.BC();
                }
                alphaAnimation = this.cMz.cMp;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cMz.cMp;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cMz.cMp;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cMz.cMq = false;
                navigationBar2 = this.cMz.cMm;
                alphaAnimation4 = this.cMz.cMp;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cMz.cMm;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cMz.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cMz.setResult(-1, intent);
            this.cMz.finish();
        }
    }
}
