package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h {
    private boolean blz;
    private View gCc;
    private ViewGroup gCd;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.gCc = view;
        this.gCd = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.blz = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.gCc != null && this.gCd != null && !this.blz) {
            this.blz = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.gCd.addView(this.mRootView, this.gCd.indexOfChild(this.gCc) + 1, this.gCc.getLayoutParams());
        }
    }

    public void dD(int i) {
        if (this.blz && this.gCc != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.gCc.getLayoutParams());
        }
    }
}
