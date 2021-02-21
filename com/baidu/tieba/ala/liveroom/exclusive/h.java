package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class h {
    private boolean bzt;
    private View hDe;
    private ViewGroup hDf;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hDe = view;
        this.hDf = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bzt = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hDe != null && this.hDf != null && !this.bzt) {
            this.bzt = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hDf.addView(this.mRootView, this.hDf.indexOfChild(this.hDe) + 1, this.hDe.getLayoutParams());
        }
    }

    public void cr(int i) {
        if (this.bzt && this.hDe != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hDe.getLayoutParams());
        }
    }
}
