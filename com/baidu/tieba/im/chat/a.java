package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity bqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bqE = absMsgImageActivity;
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
        view2 = this.bqE.mBack;
        if (view != view2) {
            if (view == this.bqE.bqq) {
                navigationBar4 = this.bqE.bqr;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bqE.bqs;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bqE.bqs;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bqE.bqp = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bqE.bqp;
                            aVar.execute(new String[0]);
                            this.bqE.bqq.setClickable(false);
                        } else {
                            this.bqE.showToast(this.bqE.getPageContext().getString(i.h.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bqE.bqv;
            if (z) {
                navigationBar = this.bqE.bqr;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bqE.bqr;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bqE.bqs;
                    multiImageView2.yZ();
                    this.bqE.bqu = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bqE.bqu = new AlphaAnimation(1.0f, 0.0f);
                    this.bqE.bqw = true;
                    multiImageView = this.bqE.bqs;
                    multiImageView.za();
                }
                alphaAnimation = this.bqE.bqu;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bqE.bqu;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bqE.bqu;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bqE.bqv = false;
                navigationBar2 = this.bqE.bqr;
                alphaAnimation4 = this.bqE.bqu;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bqE.bqr;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bqE.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bqE.setResult(-1, intent);
            this.bqE.finish();
        }
    }
}
