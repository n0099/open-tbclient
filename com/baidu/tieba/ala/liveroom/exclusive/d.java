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
import com.baidu.live.data.o;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes7.dex */
public class d extends com.baidu.live.view.f implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0629a {
    private o aEr;
    private float bjp;
    private RoundRectRelativeLayout fNM;
    private int fNN;
    private boolean gkP;
    private BdGridView gyE;
    private TextView gyF;
    private a gyG;
    private int gyH;
    private f gyI;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.gyI = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.gyH = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bHn()) {
            bHi();
        }
    }

    public void a(o oVar, int i) {
        if (!this.mActivity.isFinishing() && oVar != null && oVar.Cw()) {
            this.gyH = i;
            this.aEr = oVar;
            if (this.gyG != null) {
                this.gyG.setDatas(this.aEr.Cx());
                if (this.gyH >= 0) {
                    md(false);
                    this.gyG.tX(this.gyH);
                } else {
                    md(true);
                    this.gyG.tX(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.fNM.setCornerRadius(this.bjp, 0.0f, 0.0f, this.bjp);
                this.fNN = 5;
                int bHl = bHl();
                int bHm = bHm();
                setWidth(bHl);
                setHeight(bHm);
                showAtLocation(findViewById, 85, 0, 0);
                aa(this.fNM);
                Kl();
            }
        }
    }

    private void md(boolean z) {
        if (this.aEr != null) {
            c.a(this.mActivity, this.gyF, z, this.aEr.Cz(), this.aEr.Cy(), false);
        }
    }

    public void bHi() {
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
        this.bjp = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds36);
        this.fNM = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.gyF = (TextView) this.mRootView.findViewById(a.g.tv_land_allscene);
        this.gyF.setOnClickListener(this);
        this.gyE = (BdGridView) this.mRootView.findViewById(a.g.ala_live_land_scene_gridview);
        this.gyG = new a(this.mActivity, false);
        this.gyG.a(this);
        this.gyE.setAdapter((ListAdapter) this.gyG);
        this.fNM.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.fNM);
        setClippingEnabled(false);
    }

    private int bHl() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bHm() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Kl() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fNN) {
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

    private boolean bHn() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gkP) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fNN) {
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
                    d.this.bHi();
                    d.this.gkP = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gkP = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fA(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0629a
    public void a(View view, int i, x xVar) {
        dismiss();
        if (this.gyI != null) {
            this.gyI.a(false, view, i, xVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gyF) {
            dismiss();
            if (this.gyI != null) {
                this.gyI.a(true, this.gyF, -1, null);
            }
        }
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
