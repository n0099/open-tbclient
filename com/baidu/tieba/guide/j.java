package com.baidu.tieba.guide;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.view.GoOnAnimView;
/* loaded from: classes.dex */
public class j extends BaseFragment {
    private NewUserGuideActivity aLi;
    private ImageView aLj;
    private ImageView aLk;
    private ImageView aLl;
    private GoOnAnimView aLm;
    private ViewGroup mRootView;
    private boolean aLh = false;
    private Bitmap Hn = null;
    private Handler mHandler = new k(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aLi = (NewUserGuideActivity) getActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.w.guide_introduce, (ViewGroup) null);
            this.aLh = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.v.root_view);
            this.aLj = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_1);
            this.aLk = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_2);
            this.aLl = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_3);
            this.Hn = com.baidu.tbadk.core.util.d.a(this.aLi, com.baidu.tieba.u.pic_bg_startpage);
            if (this.Hn != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.aLi.getResources(), this.Hn));
            }
            this.aLm = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.v.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.aLm.setOnClickListener(new l(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.aLh = false;
            if (TbadkApplication.m251getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.aLi.Ix();
            TbadkApplication.m251getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy() {
        this.aLj.setImageResource(com.baidu.tieba.u.pic_startpage1_one);
        this.aLk.setImageResource(com.baidu.tieba.u.pic_startpage1_two);
        this.aLl.setImageResource(com.baidu.tieba.u.pic_startpage1_three);
        a(this.aLj, true, 0L);
        a(this.aLk, false, 100L);
        a(this.aLl, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void Iz() {
        if (this.aLm != null) {
            this.aLm.onStart();
        }
    }

    public void IA() {
        if (this.aLm != null) {
            this.aLm.onStop();
        }
    }

    private void stop() {
        if (this.aLh) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.Hn != null) {
                if (!this.Hn.isRecycled()) {
                    this.Hn.recycle();
                }
                this.Hn = null;
            }
            this.aLj.clearAnimation();
            this.aLj.setImageDrawable(null);
            this.aLk.clearAnimation();
            this.aLk.setImageDrawable(null);
            this.aLl.clearAnimation();
            this.aLl.setImageDrawable(null);
            if (this.aLm != null) {
                this.aLm.onDestroy();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
        }
    }

    private void a(ImageView imageView, boolean z, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, z ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setStartOffset(j);
        translateAnimation.setFillAfter(true);
        imageView.startAnimation(translateAnimation);
    }
}
