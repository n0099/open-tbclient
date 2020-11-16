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
import com.baidu.live.data.af;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.view.e implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0673a {
    private u aIb;
    private BdGridView bEJ;
    private int bMu;
    private RoundRectRelativeLayout boV;
    private float boY;
    private boolean gUn;
    private TextView hhC;
    private a hhD;
    private int hhE;
    private f hhF;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hhF = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hhE = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Ww()) {
            Wr();
        }
    }

    public void a(u uVar, int i) {
        if (!this.mActivity.isFinishing() && uVar != null && uVar.DB()) {
            this.hhE = i;
            this.aIb = uVar;
            if (this.hhD != null) {
                this.hhD.setDatas(this.aIb.DC());
                if (this.hhE >= 0) {
                    nk(false);
                    this.hhD.wa(this.hhE);
                } else {
                    nk(true);
                    this.hhD.wa(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.boV.setCornerRadius(this.boY, 0.0f, 0.0f, this.boY);
                this.bMu = 5;
                int Wu = Wu();
                int Wv = Wv();
                setWidth(Wu);
                setHeight(Wv);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.boV);
                Mi();
            }
        }
    }

    private void nk(boolean z) {
        if (this.aIb != null) {
            c.a(this.mActivity, this.hhC, z, this.aIb.DE(), this.aIb.DD(), false);
        }
    }

    public void Wr() {
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
        this.boY = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.boV = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hhC = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hhC.setOnClickListener(this);
        this.bEJ = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hhD = new a(this.mActivity, false);
        this.hhD.a(this);
        this.bEJ.setAdapter((ListAdapter) this.hhD);
        this.boV.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.boV);
        setClippingEnabled(false);
    }

    private int Wu() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int Wv() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Mi() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bMu) {
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

    private boolean Ww() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gUn) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bMu) {
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
                    d.this.Wr();
                    d.this.gUn = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gUn = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eT(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0673a
    public void a(View view, int i, af afVar) {
        dismiss();
        if (this.hhF != null) {
            this.hhF.a(false, view, i, afVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhC) {
            dismiss();
            if (this.hhF != null) {
                this.hhF.a(true, this.hhC, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
