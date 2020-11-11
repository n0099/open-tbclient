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
    private u aJM;
    private BdGridView bGu;
    private int bOe;
    private RoundRectRelativeLayout bqG;
    private float bqJ;
    private boolean gUG;
    private TextView hhV;
    private a hhW;
    private int hhX;
    private f hhY;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hhY = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hhX = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Xf()) {
            Xa();
        }
    }

    public void a(u uVar, int i) {
        if (!this.mActivity.isFinishing() && uVar != null && uVar.Ek()) {
            this.hhX = i;
            this.aJM = uVar;
            if (this.hhW != null) {
                this.hhW.setDatas(this.aJM.El());
                if (this.hhX >= 0) {
                    nj(false);
                    this.hhW.vC(this.hhX);
                } else {
                    nj(true);
                    this.hhW.vC(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bqG.setCornerRadius(this.bqJ, 0.0f, 0.0f, this.bqJ);
                this.bOe = 5;
                int Xd = Xd();
                int Xe = Xe();
                setWidth(Xd);
                setHeight(Xe);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.bqG);
                MR();
            }
        }
    }

    private void nj(boolean z) {
        if (this.aJM != null) {
            c.a(this.mActivity, this.hhV, z, this.aJM.En(), this.aJM.Em(), false);
        }
    }

    public void Xa() {
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
        this.bqJ = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.bqG = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hhV = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hhV.setOnClickListener(this);
        this.bGu = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hhW = new a(this.mActivity, false);
        this.hhW.a(this);
        this.bGu.setAdapter((ListAdapter) this.hhW);
        this.bqG.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bqG);
        setClippingEnabled(false);
    }

    private int Xd() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int Xe() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void MR() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bOe) {
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

    private boolean Xf() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gUG) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bOe) {
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
                    d.this.Xa();
                    d.this.gUG = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gUG = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eX(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0673a
    public void a(View view, int i, af afVar) {
        dismiss();
        if (this.hhY != null) {
            this.hhY.a(false, view, i, afVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhV) {
            dismiss();
            if (this.hhY != null) {
                this.hhY.a(true, this.hhV, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
