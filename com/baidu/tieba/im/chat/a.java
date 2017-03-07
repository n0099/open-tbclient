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
    final /* synthetic */ AbsMsgImageActivity cOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cOc = absMsgImageActivity;
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
        view2 = this.cOc.anY;
        if (view != view2) {
            if (view == this.cOc.cNO) {
                navigationBar4 = this.cOc.cNP;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cOc.cNQ;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cOc.cNQ;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cOc.cNN = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cOc.cNN;
                            aVar.execute(new String[0]);
                            this.cOc.cNO.setClickable(false);
                        } else {
                            this.cOc.showToast(this.cOc.getPageContext().getString(w.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cOc.cNT;
            if (z) {
                navigationBar = this.cOc.cNP;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cOc.cNP;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cOc.cNQ;
                    multiImageView2.Bc();
                    this.cOc.cNS = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cOc.cNS = new AlphaAnimation(1.0f, 0.0f);
                    this.cOc.cNU = true;
                    multiImageView = this.cOc.cNQ;
                    multiImageView.Bd();
                }
                alphaAnimation = this.cOc.cNS;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cOc.cNS;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cOc.cNS;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cOc.cNT = false;
                navigationBar2 = this.cOc.cNP;
                alphaAnimation4 = this.cOc.cNS;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cOc.cNP;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cOc.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cOc.setResult(-1, intent);
            this.cOc.finish();
        }
    }
}
