package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h {
    private boolean bvS;
    private View hrp;
    private ViewGroup hrq;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hrp = view;
        this.hrq = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bvS = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hrp != null && this.hrq != null && !this.bvS) {
            this.bvS = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hrq.addView(this.mRootView, this.hrq.indexOfChild(this.hrp) + 1, this.hrp.getLayoutParams());
        }
    }

    public void dX(int i) {
        if (this.bvS && this.hrp != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hrp.getLayoutParams());
        }
    }
}
