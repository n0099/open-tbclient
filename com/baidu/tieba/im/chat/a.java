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
    final /* synthetic */ AbsMsgImageActivity cIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cIT = absMsgImageActivity;
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
        view2 = this.cIT.aor;
        if (view != view2) {
            if (view == this.cIT.cIF) {
                navigationBar4 = this.cIT.cIG;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cIT.cIH;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cIT.cIH;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cIT.cIE = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cIT.cIE;
                            aVar.execute(new String[0]);
                            this.cIT.cIF.setClickable(false);
                        } else {
                            this.cIT.showToast(this.cIT.getPageContext().getString(w.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cIT.cIK;
            if (z) {
                navigationBar = this.cIT.cIG;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cIT.cIG;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cIT.cIH;
                    multiImageView2.AM();
                    this.cIT.cIJ = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cIT.cIJ = new AlphaAnimation(1.0f, 0.0f);
                    this.cIT.cIL = true;
                    multiImageView = this.cIT.cIH;
                    multiImageView.AN();
                }
                alphaAnimation = this.cIT.cIJ;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cIT.cIJ;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cIT.cIJ;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cIT.cIK = false;
                navigationBar2 = this.cIT.cIG;
                alphaAnimation4 = this.cIT.cIJ;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cIT.cIG;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cIT.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cIT.setResult(-1, intent);
            this.cIT.finish();
        }
    }
}
