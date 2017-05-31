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
    final /* synthetic */ AbsMsgImageActivity cOr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cOr = absMsgImageActivity;
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
        view2 = this.cOr.aob;
        if (view != view2) {
            if (view == this.cOr.cOd) {
                navigationBar4 = this.cOr.cOe;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cOr.cOf;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cOr.cOf;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cOr.cOc = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cOr.cOc;
                            aVar.execute(new String[0]);
                            this.cOr.cOd.setClickable(false);
                        } else {
                            this.cOr.showToast(this.cOr.getPageContext().getString(w.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cOr.cOi;
            if (z) {
                navigationBar = this.cOr.cOe;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cOr.cOe;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cOr.cOf;
                    multiImageView2.AF();
                    this.cOr.cOh = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cOr.cOh = new AlphaAnimation(1.0f, 0.0f);
                    this.cOr.cOj = true;
                    multiImageView = this.cOr.cOf;
                    multiImageView.AG();
                }
                alphaAnimation = this.cOr.cOh;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cOr.cOh;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cOr.cOh;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cOr.cOi = false;
                navigationBar2 = this.cOr.cOe;
                alphaAnimation4 = this.cOr.cOh;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cOr.cOe;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cOr.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cOr.setResult(-1, intent);
            this.cOr.finish();
        }
    }
}
