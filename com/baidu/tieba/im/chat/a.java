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
    final /* synthetic */ AbsMsgImageActivity bYh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bYh = absMsgImageActivity;
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
        view2 = this.bYh.ajA;
        if (view != view2) {
            if (view == this.bYh.bXT) {
                navigationBar4 = this.bYh.bXU;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bYh.bXV;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bYh.bXV;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bYh.bXS = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bYh.bXS;
                            aVar.execute(new String[0]);
                            this.bYh.bXT.setClickable(false);
                        } else {
                            this.bYh.showToast(this.bYh.getPageContext().getString(t.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bYh.bXY;
            if (z) {
                navigationBar = this.bYh.bXU;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bYh.bXU;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bYh.bXV;
                    multiImageView2.BC();
                    this.bYh.bXX = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bYh.bXX = new AlphaAnimation(1.0f, 0.0f);
                    this.bYh.bXZ = true;
                    multiImageView = this.bYh.bXV;
                    multiImageView.BD();
                }
                alphaAnimation = this.bYh.bXX;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bYh.bXX;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bYh.bXX;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bYh.bXY = false;
                navigationBar2 = this.bYh.bXU;
                alphaAnimation4 = this.bYh.bXX;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bYh.bXU;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bYh.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bYh.setResult(-1, intent);
            this.bYh.finish();
        }
    }
}
