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
    final /* synthetic */ AbsMsgImageActivity bnF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bnF = absMsgImageActivity;
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
        view2 = this.bnF.mBack;
        if (view != view2) {
            if (view == this.bnF.bnr) {
                navigationBar4 = this.bnF.bns;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bnF.bnt;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bnF.bnt;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bnF.bnq = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bnF.bnq;
                            aVar.execute(new String[0]);
                            this.bnF.bnr.setClickable(false);
                        } else {
                            this.bnF.showToast(this.bnF.getPageContext().getString(i.h.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bnF.bnw;
            if (z) {
                navigationBar = this.bnF.bns;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bnF.bns;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bnF.bnt;
                    multiImageView2.zq();
                    this.bnF.bnv = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bnF.bnv = new AlphaAnimation(1.0f, 0.0f);
                    this.bnF.bnx = true;
                    multiImageView = this.bnF.bnt;
                    multiImageView.zr();
                }
                alphaAnimation = this.bnF.bnv;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bnF.bnv;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bnF.bnv;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bnF.bnw = false;
                navigationBar2 = this.bnF.bns;
                alphaAnimation4 = this.bnF.bnv;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bnF.bns;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bnF.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bnF.setResult(-1, intent);
            this.bnF.finish();
        }
    }
}
