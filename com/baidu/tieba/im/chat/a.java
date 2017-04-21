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
    final /* synthetic */ AbsMsgImageActivity cOQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cOQ = absMsgImageActivity;
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
        view2 = this.cOQ.aom;
        if (view != view2) {
            if (view == this.cOQ.cOC) {
                navigationBar4 = this.cOQ.cOD;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cOQ.cOE;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cOQ.cOE;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cOQ.cOB = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cOQ.cOB;
                            aVar.execute(new String[0]);
                            this.cOQ.cOC.setClickable(false);
                        } else {
                            this.cOQ.showToast(this.cOQ.getPageContext().getString(w.l.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cOQ.cOH;
            if (z) {
                navigationBar = this.cOQ.cOD;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cOQ.cOD;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cOQ.cOE;
                    multiImageView2.BB();
                    this.cOQ.cOG = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cOQ.cOG = new AlphaAnimation(1.0f, 0.0f);
                    this.cOQ.cOI = true;
                    multiImageView = this.cOQ.cOE;
                    multiImageView.BC();
                }
                alphaAnimation = this.cOQ.cOG;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cOQ.cOG;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cOQ.cOG;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cOQ.cOH = false;
                navigationBar2 = this.cOQ.cOD;
                alphaAnimation4 = this.cOQ.cOG;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cOQ.cOD;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cOQ.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.cOQ.setResult(-1, intent);
            this.cOQ.finish();
        }
    }
}
