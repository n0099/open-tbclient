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
public class d extends com.baidu.live.view.f implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0643a {
    private r aIw;
    private int bFz;
    private RoundRectRelativeLayout bnA;
    private float bnD;
    private boolean gCt;
    private BdGridView gQm;
    private TextView gQn;
    private a gQo;
    private int gQp;
    private f gQq;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.gQq = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.gQp = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.f, android.widget.PopupWindow
    public void dismiss() {
        if (!TF()) {
            TA();
        }
    }

    public void a(r rVar, int i) {
        if (!this.mActivity.isFinishing() && rVar != null && rVar.DI()) {
            this.gQp = i;
            this.aIw = rVar;
            if (this.gQo != null) {
                this.gQo.setDatas(this.aIw.DJ());
                if (this.gQp >= 0) {
                    mK(false);
                    this.gQo.uV(this.gQp);
                } else {
                    mK(true);
                    this.gQo.uV(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bnA.setCornerRadius(this.bnD, 0.0f, 0.0f, this.bnD);
                this.bFz = 5;
                int TD = TD();
                int TE = TE();
                setWidth(TD);
                setHeight(TE);
                showAtLocation(findViewById, 85, 0, 0);
                ad(this.bnA);
                LX();
            }
        }
    }

    private void mK(boolean z) {
        if (this.aIw != null) {
            c.a(this.mActivity, this.gQn, z, this.aIw.DL(), this.aIw.DK(), false);
        }
    }

    public void TA() {
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
        this.bnD = this.mActivity.getResources().getDimensionPixelOffset(a.e.sdk_ds36);
        this.bnA = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.h.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.gQn = (TextView) this.mRootView.findViewById(a.g.tv_land_allscene);
        this.gQn.setOnClickListener(this);
        this.gQm = (BdGridView) this.mRootView.findViewById(a.g.ala_live_land_scene_gridview);
        this.gQo = new a(this.mActivity, false);
        this.gQo.a(this);
        this.gQm.setAdapter((ListAdapter) this.gQo);
        this.bnA.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bnA);
        setClippingEnabled(false);
    }

    private int TD() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int TE() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void LX() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bFz) {
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

    private boolean TF() {
        if (getContentView() == null) {
            return false;
        }
        if (this.gCt) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bFz) {
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
                    d.this.TA();
                    d.this.gCt = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.gCt = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void eU(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0643a
    public void a(View view, int i, ac acVar) {
        dismiss();
        if (this.gQq != null) {
            this.gQq.a(false, view, i, acVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gQn) {
            dismiss();
            if (this.gQq != null) {
                this.gQq.a(true, this.gQn, -1, null);
            }
        }
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
