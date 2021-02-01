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
/* loaded from: classes11.dex */
public class d extends com.baidu.live.view.e implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0662a {
    private z aIW;
    private float bAh;
    private BdGridView bND;
    private RoundRectRelativeLayout bWv;
    private int bWw;
    private boolean hCH;
    private TextView hCI;
    private a hCJ;
    private int hCK;
    private f hCL;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hCL = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hCK = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Yi()) {
            Yc();
        }
    }

    public void a(z zVar, int i) {
        if (!this.mActivity.isFinishing() && zVar != null && zVar.BU()) {
            this.hCK = i;
            this.aIW = zVar;
            if (this.hCJ != null) {
                this.hCJ.setDatas(this.aIW.BV());
                if (this.hCK >= 0) {
                    om(false);
                    this.hCJ.vv(this.hCK);
                } else {
                    om(true);
                    this.hCJ.vv(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bWv.setCornerRadius(this.bAh, 0.0f, 0.0f, this.bAh);
                this.bWw = 5;
                int Yg = Yg();
                int Yh = Yh();
                setWidth(Yg);
                setHeight(Yh);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.bWv);
                LN();
            }
        }
    }

    private void om(boolean z) {
        if (this.aIW != null) {
            c.a(this.mActivity, this.hCI, z, this.aIW.BX(), this.aIW.BW(), false);
        }
    }

    public void Yc() {
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
        this.bAh = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.bWv = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hCI = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hCI.setOnClickListener(this);
        this.bND = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hCJ = new a(this.mActivity, false);
        this.hCJ.a(this);
        this.bND.setAdapter((ListAdapter) this.hCJ);
        this.bWv.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bWv);
    }

    private int Yg() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int Yh() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void LN() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bWw) {
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

    private boolean Yi() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hCH) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bWw) {
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
                    d.this.Yc();
                    d.this.hCH = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hCH = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fp(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0662a
    public void a(View view, int i, an anVar) {
        dismiss();
        if (this.hCL != null) {
            this.hCL.a(false, view, i, anVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCI) {
            dismiss();
            if (this.hCL != null) {
                this.hCL.a(true, this.hCI, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
