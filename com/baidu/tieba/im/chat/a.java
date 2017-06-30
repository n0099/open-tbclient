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
    final /* synthetic */ AbsMsgImageActivity cWn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cWn = absMsgImageActivity;
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
        view2 = this.cWn.apb;
        if (view != view2) {
            if (view == this.cWn.cVZ) {
                navigationBar4 = this.cWn.cWa;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cWn.cWb;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cWn.cWb;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cWn.cVY = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cWn.cVY;
                            aVar.execute(new String[0]);
                            this.cWn.cVZ.setClickable(false);
                        } else {
                            this.cWn.showToast(this.cWn.getPageContext().getString(w.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cWn.cWe;
            if (z) {
                navigationBar = this.cWn.cWa;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cWn.cWa;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cWn.cWb;
                    multiImageView2.Ba();
                    this.cWn.cWd = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cWn.cWd = new AlphaAnimation(1.0f, 0.0f);
                    this.cWn.cWf = true;
                    multiImageView = this.cWn.cWb;
                    multiImageView.Bb();
                }
                alphaAnimation = this.cWn.cWd;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cWn.cWd;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cWn.cWd;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cWn.cWe = false;
                navigationBar2 = this.cWn.cWa;
                alphaAnimation4 = this.cWn.cWd;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cWn.cWa;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cWn.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cWn.setResult(-1, intent);
            this.cWn.finish();
        }
    }
}
