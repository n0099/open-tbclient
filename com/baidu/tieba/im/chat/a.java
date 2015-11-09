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
    final /* synthetic */ AbsMsgImageActivity brt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.brt = absMsgImageActivity;
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
        view2 = this.brt.mBack;
        if (view != view2) {
            if (view == this.brt.brf) {
                navigationBar4 = this.brt.brg;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.brt.brh;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.brt.brh;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.brt.bre = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.brt.bre;
                            aVar.execute(new String[0]);
                            this.brt.brf.setClickable(false);
                        } else {
                            this.brt.showToast(this.brt.getPageContext().getString(i.h.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.brt.brk;
            if (z) {
                navigationBar = this.brt.brg;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.brt.brg;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.brt.brh;
                    multiImageView2.zb();
                    this.brt.brj = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.brt.brj = new AlphaAnimation(1.0f, 0.0f);
                    this.brt.brl = true;
                    multiImageView = this.brt.brh;
                    multiImageView.zc();
                }
                alphaAnimation = this.brt.brj;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.brt.brj;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.brt.brj;
                alphaAnimation3.setAnimationListener(new b(this));
                this.brt.brk = false;
                navigationBar2 = this.brt.brg;
                alphaAnimation4 = this.brt.brj;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.brt.brg;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.brt.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.brt.setResult(-1, intent);
            this.brt.finish();
        }
    }
}
