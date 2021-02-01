package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class h {
    private boolean bzt;
    private View hCQ;
    private ViewGroup hCR;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hCQ = view;
        this.hCR = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bzt = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hCQ != null && this.hCR != null && !this.bzt) {
            this.bzt = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hCR.addView(this.mRootView, this.hCR.indexOfChild(this.hCQ) + 1, this.hCQ.getLayoutParams());
        }
    }

    public void cr(int i) {
        if (this.bzt && this.hCQ != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hCQ.getLayoutParams());
        }
    }
}
