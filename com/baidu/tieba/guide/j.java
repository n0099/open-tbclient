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
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class j extends BaseFragment {
    private NewUserGuideActivity aNp;
    private ImageView aNq;
    private ImageView aNr;
    private ImageView aNs;
    private GoOnAnimView aNt;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap Mi = null;
    private Handler mHandler = new k(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aNp = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(x.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.w.root_view);
            this.aNq = (ImageView) viewGroup2.findViewById(com.baidu.tieba.w.image_tip_1);
            this.aNr = (ImageView) viewGroup2.findViewById(com.baidu.tieba.w.image_tip_2);
            this.aNs = (ImageView) viewGroup2.findViewById(com.baidu.tieba.w.image_tip_3);
            this.Mi = com.baidu.tbadk.core.util.d.b(this.aNp.getPageContext().getPageActivity(), com.baidu.tieba.v.pic_bg_startpage);
            if (this.Mi != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.aNp.getResources(), this.Mi));
            }
            this.aNt = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.w.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.aNt.setOnClickListener(new l(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.isInit = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.aNp.IS();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        this.aNq.setImageResource(com.baidu.tieba.v.pic_startpage1_one);
        this.aNr.setImageResource(com.baidu.tieba.v.pic_startpage1_two);
        this.aNs.setImageResource(com.baidu.tieba.v.pic_startpage1_three);
        a(this.aNq, true, 0L);
        a(this.aNr, false, 100L);
        a(this.aNs, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void IU() {
        if (this.aNt != null) {
            this.aNt.onStart();
        }
    }

    public void IV() {
        if (this.aNt != null) {
            this.aNt.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.Mi != null) {
                if (!this.Mi.isRecycled()) {
                    this.Mi.recycle();
                }
                this.Mi = null;
            }
            this.aNq.clearAnimation();
            this.aNq.setImageDrawable(null);
            this.aNr.clearAnimation();
            this.aNr.setImageDrawable(null);
            this.aNs.clearAnimation();
            this.aNs.setImageDrawable(null);
            if (this.aNt != null) {
                this.aNt.onDestroy();
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
