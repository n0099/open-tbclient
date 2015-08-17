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
    final /* synthetic */ AbsMsgImageActivity bnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.bnh = absMsgImageActivity;
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
        view2 = this.bnh.mBack;
        if (view != view2) {
            if (view == this.bnh.bmT) {
                navigationBar4 = this.bnh.bmU;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.bnh.bmV;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.bnh.bmV;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.bnh.bmS = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.bnh.bmS;
                            aVar.execute(new String[0]);
                            this.bnh.bmT.setClickable(false);
                        } else {
                            this.bnh.showToast(this.bnh.getPageContext().getString(i.C0057i.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.bnh.bmY;
            if (z) {
                navigationBar = this.bnh.bmU;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.bnh.bmU;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.bnh.bmV;
                    multiImageView2.zj();
                    this.bnh.bmX = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.bnh.bmX = new AlphaAnimation(1.0f, 0.0f);
                    this.bnh.bmZ = true;
                    multiImageView = this.bnh.bmV;
                    multiImageView.zk();
                }
                alphaAnimation = this.bnh.bmX;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.bnh.bmX;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.bnh.bmX;
                alphaAnimation3.setAnimationListener(new b(this));
                this.bnh.bmY = false;
                navigationBar2 = this.bnh.bmU;
                alphaAnimation4 = this.bnh.bmX;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.bnh.bmU;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.bnh.mIndex;
            intent.putExtra(ImageViewerConfig.INDEX, i);
            this.bnh.setResult(-1, intent);
            this.bnh.finish();
        }
    }
}
