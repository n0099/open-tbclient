package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h {
    private boolean bss;
    private View hie;
    private ViewGroup hif;
    private Activity mActivity;
    private View mRootView;

    public h(Activity activity, View view) {
        this.mActivity = activity;
        this.hie = view;
        this.hif = (ViewGroup) view.getParent();
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_sdk_scene_loading_view, (ViewGroup) null);
    }

    public void dismiss() {
        this.bss = false;
        if (this.mRootView != null && this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
    }

    public void show() {
        if (!this.mActivity.isFinishing() && this.hie != null && this.hif != null && !this.bss) {
            this.bss = true;
            if (this.mRootView.getParent() != null) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            this.hif.addView(this.mRootView, this.hif.indexOfChild(this.hie) + 1, this.hie.getLayoutParams());
        }
    }

    public void dI(int i) {
        if (this.bss && this.hie != null && this.mRootView != null) {
            this.mRootView.setLayoutParams(this.hie.getLayoutParams());
        }
    }
}
