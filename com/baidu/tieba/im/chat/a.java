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
    final /* synthetic */ AbsMsgImageActivity cLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cLO = absMsgImageActivity;
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
        view2 = this.cLO.aiC;
        if (view != view2) {
            if (view == this.cLO.cLA) {
                navigationBar4 = this.cLO.cLB;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cLO.cLC;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cLO.cLC;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cLO.cLz = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cLO.cLz;
                            aVar.execute(new String[0]);
                            this.cLO.cLA.setClickable(false);
                        } else {
                            this.cLO.showToast(this.cLO.getPageContext().getString(r.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cLO.cLF;
            if (z) {
                navigationBar = this.cLO.cLB;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cLO.cLB;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cLO.cLC;
                    multiImageView2.AJ();
                    this.cLO.cLE = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cLO.cLE = new AlphaAnimation(1.0f, 0.0f);
                    this.cLO.cLG = true;
                    multiImageView = this.cLO.cLC;
                    multiImageView.AK();
                }
                alphaAnimation = this.cLO.cLE;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cLO.cLE;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cLO.cLE;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cLO.cLF = false;
                navigationBar2 = this.cLO.cLB;
                alphaAnimation4 = this.cLO.cLE;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cLO.cLB;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cLO.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cLO.setResult(-1, intent);
            this.cLO.finish();
        }
    }
}
