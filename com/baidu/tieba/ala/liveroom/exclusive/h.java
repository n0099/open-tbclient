package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h {
    private boolean bpm;
    private View gQv;
    private ViewGroup gQw;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.gQv = view;
        this.gQw = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bpm = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.gQv != null && this.gQw != null && !this.bpm) {
            this.bpm = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.gQw.addView(this.mRootView, this.gQw.indexOfChild(this.gQv) + 1, this.gQv.getLayoutParams());
        }
    }

    public void dI(int i) {
        if (this.bpm && this.gQv != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.gQv.getLayoutParams());
        }
    }
}
