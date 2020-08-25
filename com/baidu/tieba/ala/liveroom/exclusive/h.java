package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class h {
    private boolean biC;
    private View gyN;
    private ViewGroup gyO;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.gyN = view;
        this.gyO = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.biC = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.gyN != null && this.gyO != null && !this.biC) {
            this.biC = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.gyO.addView(this.mRootView, this.gyO.indexOfChild(this.gyN) + 1, this.gyN.getLayoutParams());
        }
    }

    public void dz(int i) {
        if (this.biC && this.gyN != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.gyN.getLayoutParams());
        }
    }
}
