package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity bGz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bGz = absMsgImageActivity;
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
        view2 = this.bGz.mBack;
        if (view != view2) {
            if (view == this.bGz.bGl) {
                navigationBar4 = this.bGz.bGm;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bGz.bGn;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bGz.bGn;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bGz.bGk = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bGz.bGk;
                            aVar.execute(new String[0]);
                            this.bGz.bGl.setClickable(false);
                        } else {
                            this.bGz.showToast(this.bGz.getPageContext().getString(n.i.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bGz.bGq;
            if (z) {
                navigationBar = this.bGz.bGm;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bGz.bGm;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bGz.bGn;
                    multiImageView2.zX();
                    this.bGz.bGp = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bGz.bGp = new AlphaAnimation(1.0f, 0.0f);
                    this.bGz.bGr = true;
                    multiImageView = this.bGz.bGn;
                    multiImageView.zY();
                }
                alphaAnimation = this.bGz.bGp;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bGz.bGp;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bGz.bGp;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bGz.bGq = false;
                navigationBar2 = this.bGz.bGm;
                alphaAnimation4 = this.bGz.bGp;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bGz.bGm;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bGz.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bGz.setResult(-1, intent);
            this.bGz.finish();
        }
    }
}
