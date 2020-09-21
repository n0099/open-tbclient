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
import com.baidu.live.data.ac;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.view.f implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0625a {
    private r aFs;
    private RoundRectRelativeLayout bjN;
    private float bjQ;
    private int byW;
    private BdGridView gBT;
    private TextView gBU;
    private a gBV;
    private int gBW;
    private f gBX;
    private boolean goa;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.gBX = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.gBW = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!RM()) {
            RH();
        }
    }

    public void a(r rVar, int i) {
        if (!this.mActivity.isFinishing() && rVar != null && rVar.CL()) {
            this.gBW = i;
            this.aFs = rVar;
            if (this.gBV != null) {
                this.gBV.setDatas(this.aFs.CM());
                if (this.gBW >= 0) {
                    mi(false);
                    this.gBV.uq(this.gBW);
                } else {
                    mi(true);
                    this.gBV.uq(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bjN.setCornerRadius(this.bjQ, 0.0f, 0.0f, this.bjQ);
                this.byW = 5;
                int RK = RK();
                int RL = RL();
                setWidth(RK);
                setHeight(RL);
                showAtLocation(findViewById, 85, 0, 0);
                ac(this.bjN);
                KS();
            }
        }
    }

    private void mi(boolean z) {
        if (this.aFs != null) {
            c.a(this.mActivity, this.gBU, z, this.aFs.CO(), this.aFs.CN(), false);
        }
    }

    public void RH() {
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
        this.bjQ = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds36);
        this.bjN = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.gBU = (TextView) this.mRootView.findViewById(a.g.tv_land_allscene);
        this.gBU.setOnClickListener(this);
        this.gBT = (BdGridView) this.mRootView.findViewById(a.g.ala_live_land_scene_gridview);
        this.gBV = new a(this.mActivity, false);
        this.gBV.a(this);
        this.gBT.setAdapter((ListAdapter) this.gBV);
        this.bjN.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bjN);
        setClippingEnabled(false);
    }

    private int RK() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int RL() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void KS() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.byW) {
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

    private boolean RM() {
        if (getContentView() == null) {
            return false;
        }
        if (this.goa) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.byW) {
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
                    d.this.RH();
                    d.this.goa = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.goa = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eL(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0625a
    public void a(View view, int i, ac acVar) {
        dismiss();
        if (this.gBX != null) {
            this.gBX.a(false, view, i, acVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gBU) {
            dismiss();
            if (this.gBX != null) {
                this.gBX.a(true, this.gBU, -1, null);
            }
        }
    }

    private void ac(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
