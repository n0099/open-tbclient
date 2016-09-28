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
    final /* synthetic */ AbsMsgImageActivity cTL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cTL = absMsgImageActivity;
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
        view2 = this.cTL.aiY;
        if (view != view2) {
            if (view == this.cTL.cTx) {
                navigationBar4 = this.cTL.cTy;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cTL.cTz;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cTL.cTz;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cTL.cTw = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cTL.cTw;
                            aVar.execute(new String[0]);
                            this.cTL.cTx.setClickable(false);
                        } else {
                            this.cTL.showToast(this.cTL.getPageContext().getString(r.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cTL.cTC;
            if (z) {
                navigationBar = this.cTL.cTy;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cTL.cTy;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cTL.cTz;
                    multiImageView2.AU();
                    this.cTL.cTB = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cTL.cTB = new AlphaAnimation(1.0f, 0.0f);
                    this.cTL.cTD = true;
                    multiImageView = this.cTL.cTz;
                    multiImageView.AV();
                }
                alphaAnimation = this.cTL.cTB;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cTL.cTB;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cTL.cTB;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cTL.cTC = false;
                navigationBar2 = this.cTL.cTy;
                alphaAnimation4 = this.cTL.cTB;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cTL.cTy;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cTL.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cTL.setResult(-1, intent);
            this.cTL.finish();
        }
    }
}
