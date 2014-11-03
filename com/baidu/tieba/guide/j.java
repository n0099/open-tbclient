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
    private GoOnAnimView aLA;
    private NewUserGuideActivity aLw;
    private ImageView aLx;
    private ImageView aLy;
    private ImageView aLz;
    private ViewGroup mRootView;
    private boolean aLv = false;
    private Bitmap Ho = null;
    private Handler mHandler = new k(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aLw = (NewUserGuideActivity) getActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.w.guide_introduce, (ViewGroup) null);
            this.aLv = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.v.root_view);
            this.aLx = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_1);
            this.aLy = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_2);
            this.aLz = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_3);
            this.Ho = com.baidu.tbadk.core.util.d.a(this.aLw, com.baidu.tieba.u.pic_bg_startpage);
            if (this.Ho != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.aLw.getResources(), this.Ho));
            }
            this.aLA = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.v.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.aLA.setOnClickListener(new l(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.aLv = false;
            if (TbadkApplication.m251getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.aLw.IB();
            TbadkApplication.m251getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IC() {
        this.aLx.setImageResource(com.baidu.tieba.u.pic_startpage1_one);
        this.aLy.setImageResource(com.baidu.tieba.u.pic_startpage1_two);
        this.aLz.setImageResource(com.baidu.tieba.u.pic_startpage1_three);
        a(this.aLx, true, 0L);
        a(this.aLy, false, 100L);
        a(this.aLz, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void ID() {
        if (this.aLA != null) {
            this.aLA.onStart();
        }
    }

    public void IE() {
        if (this.aLA != null) {
            this.aLA.onStop();
        }
    }

    private void stop() {
        if (this.aLv) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.Ho != null) {
                if (!this.Ho.isRecycled()) {
                    this.Ho.recycle();
                }
                this.Ho = null;
            }
            this.aLx.clearAnimation();
            this.aLx.setImageDrawable(null);
            this.aLy.clearAnimation();
            this.aLy.setImageDrawable(null);
            this.aLz.clearAnimation();
            this.aLz.setImageDrawable(null);
            if (this.aLA != null) {
                this.aLA.onDestroy();
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
