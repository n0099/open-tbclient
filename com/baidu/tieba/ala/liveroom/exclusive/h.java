package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h {
    private boolean bqH;
    private View hhK;
    private ViewGroup hhL;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hhK = view;
        this.hhL = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bqH = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hhK != null && this.hhL != null && !this.bqH) {
            this.bqH = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hhL.addView(this.mRootView, this.hhL.indexOfChild(this.hhK) + 1, this.hhK.getLayoutParams());
        }
    }

    public void dE(int i) {
        if (this.bqH && this.hhK != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hhK.getLayoutParams());
        }
    }
}
