package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class h {
    private boolean bAD;
    private View hDl;
    private ViewGroup hDm;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hDl = view;
        this.hDm = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bAD = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hDl != null && this.hDm != null && !this.bAD) {
            this.bAD = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hDm.addView(this.mRootView, this.hDm.indexOfChild(this.hDl) + 1, this.hDl.getLayoutParams());
        }
    }

    public void dU(int i) {
        if (this.bAD && this.hDl != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hDl.getLayoutParams());
        }
    }
}
