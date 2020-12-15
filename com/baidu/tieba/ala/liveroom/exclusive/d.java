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
import com.baidu.live.data.ah;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes4.dex */
public class d extends com.baidu.live.view.e implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0687a {
    private u aKN;
    private BdGridView bJR;
    private int bRA;
    private RoundRectRelativeLayout bue;
    private float bui;
    private boolean hdC;
    private TextView hrh;
    private a hri;
    private int hrj;
    private f hrk;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hrk = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hrj = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!YV()) {
            YQ();
        }
    }

    public void a(u uVar, int i) {
        if (!this.mActivity.isFinishing() && uVar != null && uVar.Fm()) {
            this.hrj = i;
            this.aKN = uVar;
            if (this.hri != null) {
                this.hri.setDatas(this.aKN.Fn());
                if (this.hrj >= 0) {
                    nF(false);
                    this.hri.wF(this.hrj);
                } else {
                    nF(true);
                    this.hri.wF(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bue.setCornerRadius(this.bui, 0.0f, 0.0f, this.bui);
                this.bRA = 5;
                int YT = YT();
                int YU = YU();
                setWidth(YT);
                setHeight(YU);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.bue);
                OD();
            }
        }
    }

    private void nF(boolean z) {
        if (this.aKN != null) {
            c.a(this.mActivity, this.hrh, z, this.aKN.Fp(), this.aKN.Fo(), false);
        }
    }

    public void YQ() {
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
        this.bui = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.bue = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hrh = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hrh.setOnClickListener(this);
        this.bJR = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hri = new a(this.mActivity, false);
        this.hri.a(this);
        this.bJR.setAdapter((ListAdapter) this.hri);
        this.bue.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bue);
        setClippingEnabled(false);
    }

    private int YT() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int YU() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void OD() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bRA) {
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

    private boolean YV() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hdC) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bRA) {
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
                    d.this.YQ();
                    d.this.hdC = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hdC = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0687a
    public void a(View view, int i, ah ahVar) {
        dismiss();
        if (this.hrk != null) {
            this.hrk.a(false, view, i, ahVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hrh) {
            dismiss();
            if (this.hrk != null) {
                this.hrk.a(true, this.hrh, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
