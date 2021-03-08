package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class h {
    private boolean bAT;
    private View hEN;
    private ViewGroup hEO;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hEN = view;
        this.hEO = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bAT = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hEN != null && this.hEO != null && !this.bAT) {
            this.bAT = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hEO.addView(this.mRootView, this.hEO.indexOfChild(this.hEN) + 1, this.hEN.getLayoutParams());
        }
    }

    public void cs(int i) {
        if (this.bAT && this.hEN != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hEN.getLayoutParams());
        }
    }
}
