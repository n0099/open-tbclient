package com.baidu.tieba.ala.liveroom.exclusive;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.data.ae;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.view.f implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0659a {
    private u aIT;
    private BdGridView bAj;
    private int bIy;
    private RoundRectRelativeLayout bpn;
    private float bpq;
    private boolean gOh;
    private TextView hca;
    private a hcb;
    private int hcc;
    private f hcd;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hcd = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hcc = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!UF()) {
            UA();
        }
    }

    public void a(u uVar, int i) {
        if (!this.mActivity.isFinishing() && uVar != null && uVar.DR()) {
            this.hcc = i;
            this.aIT = uVar;
            if (this.hcb != null) {
                this.hcb.setDatas(this.aIT.DS());
                if (this.hcc >= 0) {
                    na(false);
                    this.hcb.vp(this.hcc);
                } else {
                    na(true);
                    this.hcb.vp(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bpn.setCornerRadius(this.bpq, 0.0f, 0.0f, this.bpq);
                this.bIy = 5;
                int UD = UD();
                int UE = UE();
                setWidth(UD);
                setHeight(UE);
                showAtLocation(findViewById, 85, 0, 0);
                ad(this.bpn);
                Mr();
            }
        }
    }

    private void na(boolean z) {
        if (this.aIT != null) {
            c.a(this.mActivity, this.hca, z, this.aIT.DU(), this.aIT.DT(), false);
        }
    }

    public void UA() {
        super.dismiss();
    }

    private void init() {
        initView();
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setOutsideTouchable(true);
    }

    private void initView() {
        this.bpq = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds36);
        this.bpn = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hca = (TextView) this.mRootView.findViewById(a.g.tv_land_allscene);
        this.hca.setOnClickListener(this);
        this.bAj = (BdGridView) this.mRootView.findViewById(a.g.ala_live_land_scene_gridview);
        this.hcb = new a(this.mActivity, false);
        this.hcb.a(this);
        this.bAj.setAdapter((ListAdapter) this.hcb);
        this.bpn.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bpn);
        setClippingEnabled(false);
    }

    private int UD() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int UE() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Mr() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bIy) {
                case 5:
                    translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                    break;
                case 80:
                    translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    break;
            }
            if (translateAnimation != null) {
                translateAnimation.setDuration(250L);
                translateAnimation.setInterpolator(new LinearInterpolator());
                getContentView().startAnimation(translateAnimation);
            }
        }
    }

    private boolean UF() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gOh) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bIy) {
            case 5:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                break;
            case 80:
                translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
                break;
        }
        if (translateAnimation != null) {
            translateAnimation.setDuration(250L);
            translateAnimation.setInterpolator(new LinearInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.d.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    d.this.UA();
                    d.this.gOh = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gOh = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0659a
    public void a(View view, int i, ae aeVar) {
        dismiss();
        if (this.hcd != null) {
            this.hcd.a(false, view, i, aeVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hca) {
            dismiss();
            if (this.hcd != null) {
                this.hcd.a(true, this.hca, -1, null);
            }
        }
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
