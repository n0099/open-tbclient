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
    private o aEt;
    private float bjs;
    private RoundRectRelativeLayout fNQ;
    private int fNR;
    private boolean gkT;
    private BdGridView gyI;
    private TextView gyJ;
    private a gyK;
    private int gyL;
    private f gyM;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.gyM = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.gyL = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!bHo()) {
            bHj();
        }
    }

    public void a(o oVar, int i) {
        if (!this.mActivity.isFinishing() && oVar != null && oVar.Cw()) {
            this.gyL = i;
            this.aEt = oVar;
            if (this.gyK != null) {
                this.gyK.setDatas(this.aEt.Cx());
                if (this.gyL >= 0) {
                    mf(false);
                    this.gyK.tX(this.gyL);
                } else {
                    mf(true);
                    this.gyK.tX(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.fNQ.setCornerRadius(this.bjs, 0.0f, 0.0f, this.bjs);
                this.fNR = 5;
                int bHm = bHm();
                int bHn = bHn();
                setWidth(bHm);
                setHeight(bHn);
                showAtLocation(findViewById, 85, 0, 0);
                aa(this.fNQ);
                Kl();
            }
        }
    }

    private void mf(boolean z) {
        if (this.aEt != null) {
            c.a(this.mActivity, this.gyJ, z, this.aEt.Cz(), this.aEt.Cy(), false);
        }
    }

    public void bHj() {
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
        this.bjs = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds36);
        this.fNQ = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.gyJ = (TextView) this.mRootView.findViewById(a.g.tv_land_allscene);
        this.gyJ.setOnClickListener(this);
        this.gyI = (BdGridView) this.mRootView.findViewById(a.g.ala_live_land_scene_gridview);
        this.gyK = new a(this.mActivity, false);
        this.gyK.a(this);
        this.gyI.setAdapter((ListAdapter) this.gyK);
        this.fNQ.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.fNQ);
        setClippingEnabled(false);
    }

    private int bHm() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int bHn() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Kl() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.fNR) {
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

    private boolean bHo() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gkT) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.fNR) {
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
                    d.this.bHj();
                    d.this.gkT = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gkT = true;
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
        if (this.gyM != null) {
            this.gyM.a(false, view, i, xVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gyJ) {
            dismiss();
            if (this.gyM != null) {
                this.gyM.a(true, this.gyJ, -1, null);
            }
        }
    }

    private void aa(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
