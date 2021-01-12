package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class h {
    private boolean bvR;
    private View hyF;
    private ViewGroup hyG;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hyF = view;
        this.hyG = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bvR = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hyF != null && this.hyG != null && !this.bvR) {
            this.bvR = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hyG.addView(this.mRootView, this.hyG.indexOfChild(this.hyF) + 1, this.hyF.getLayoutParams());
        }
    }

    public void co(int i) {
        if (this.bvR && this.hyF != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hyF.getLayoutParams());
        }
    }
}
