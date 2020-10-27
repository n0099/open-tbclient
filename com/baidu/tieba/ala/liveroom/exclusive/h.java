package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h {
    private boolean bqZ;
    private View hci;
    private ViewGroup hcj;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hci = view;
        this.hcj = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bqZ = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hci != null && this.hcj != null && !this.bqZ) {
            this.bqZ = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hcj.addView(this.mRootView, this.hcj.indexOfChild(this.hci) + 1, this.hci.getLayoutParams());
        }
    }

    public void dI(int i) {
        if (this.bqZ && this.hci != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hci.getLayoutParams());
        }
    }
}
