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
import com.baidu.live.data.an;
import com.baidu.live.data.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes10.dex */
public class d extends com.baidu.live.view.e implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0669a {
    private z aKw;
    private float bBH;
    private BdGridView bPd;
    private RoundRectRelativeLayout bXV;
    private int bXW;
    private boolean hEE;
    private TextView hEF;
    private a hEG;
    private int hEH;
    private f hEI;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hEI = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hEH = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Yl()) {
            Yf();
        }
    }

    public void a(z zVar, int i) {
        if (!this.mActivity.isFinishing() && zVar != null && zVar.BX()) {
            this.hEH = i;
            this.aKw = zVar;
            if (this.hEG != null) {
                this.hEG.setDatas(this.aKw.BY());
                if (this.hEH >= 0) {
                    om(false);
                    this.hEG.vx(this.hEH);
                } else {
                    om(true);
                    this.hEG.vx(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bXV.setCornerRadius(this.bBH, 0.0f, 0.0f, this.bBH);
                this.bXW = 5;
                int Yj = Yj();
                int Yk = Yk();
                setWidth(Yj);
                setHeight(Yk);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.bXV);
                LQ();
            }
        }
    }

    private void om(boolean z) {
        if (this.aKw != null) {
            c.a(this.mActivity, this.hEF, z, this.aKw.Ca(), this.aKw.BZ(), false);
        }
    }

    public void Yf() {
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
        this.bBH = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.bXV = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hEF = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hEF.setOnClickListener(this);
        this.bPd = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hEG = new a(this.mActivity, false);
        this.hEG.a(this);
        this.bPd.setAdapter((ListAdapter) this.hEG);
        this.bXV.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bXV);
    }

    private int Yj() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int Yk() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void LQ() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXW) {
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

    private boolean Yl() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hEE) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bXW) {
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
                    d.this.Yf();
                    d.this.hEE = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hEE = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fq(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0669a
    public void a(View view, int i, an anVar) {
        dismiss();
        if (this.hEI != null) {
            this.hEI.a(false, view, i, anVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hEF) {
            dismiss();
            if (this.hEI != null) {
                this.hEI.a(true, this.hEF, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
