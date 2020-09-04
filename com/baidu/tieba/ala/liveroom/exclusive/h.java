package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class h {
    private boolean biF;
    private View gyR;
    private ViewGroup gyS;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.gyR = view;
        this.gyS = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.biF = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.gyR != null && this.gyS != null && !this.biF) {
            this.biF = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.gyS.addView(this.mRootView, this.gyS.indexOfChild(this.gyR) + 1, this.gyR.getLayoutParams());
        }
    }

    public void dz(int i) {
        if (this.biF && this.gyR != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.gyR.getLayoutParams());
        }
    }
}
