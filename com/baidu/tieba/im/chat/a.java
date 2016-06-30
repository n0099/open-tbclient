package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ AbsMsgImageActivity cDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbsMsgImageActivity absMsgImageActivity) {
        this.cDW = absMsgImageActivity;
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
        view2 = this.cDW.afN;
        if (view != view2) {
            if (view == this.cDW.cDI) {
                navigationBar4 = this.cDW.cDJ;
                if (navigationBar4.getVisibility() != 8) {
                    try {
                        multiImageView3 = this.cDW.cDK;
                        byte[] currentImageData = multiImageView3.getCurrentImageData();
                        if (currentImageData != null) {
                            multiImageView4 = this.cDW.cDK;
                            String currentImageUrl = multiImageView4.getCurrentImageUrl();
                            this.cDW.cDH = new AbsMsgImageActivity.a(currentImageUrl, currentImageData);
                            aVar = this.cDW.cDH;
                            aVar.execute(new String[0]);
                            this.cDW.cDI.setClickable(false);
                        } else {
                            this.cDW.showToast(this.cDW.getPageContext().getString(u.j.no_data));
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            z = this.cDW.cDN;
            if (z) {
                navigationBar = this.cDW.cDJ;
                if (navigationBar.getVisibility() != 0) {
                    navigationBar3 = this.cDW.cDJ;
                    navigationBar3.setVisibility(0);
                    multiImageView2 = this.cDW.cDK;
                    multiImageView2.zC();
                    this.cDW.cDM = new AlphaAnimation(0.0f, 1.0f);
                } else {
                    this.cDW.cDM = new AlphaAnimation(1.0f, 0.0f);
                    this.cDW.cDO = true;
                    multiImageView = this.cDW.cDK;
                    multiImageView.zD();
                }
                alphaAnimation = this.cDW.cDM;
                alphaAnimation.setDuration(300L);
                alphaAnimation2 = this.cDW.cDM;
                alphaAnimation2.setFillAfter(true);
                alphaAnimation3 = this.cDW.cDM;
                alphaAnimation3.setAnimationListener(new b(this));
                this.cDW.cDN = false;
                navigationBar2 = this.cDW.cDJ;
                alphaAnimation4 = this.cDW.cDM;
                navigationBar2.startAnimation(alphaAnimation4);
                return;
            }
            return;
        }
        navigationBar5 = this.cDW.cDJ;
        if (navigationBar5.getVisibility() != 8) {
            Intent intent = new Intent();
            i = this.cDW.mIndex;
            intent.putExtra("index", i);
            this.cDW.setResult(-1, intent);
            this.cDW.finish();
        }
    }
}
