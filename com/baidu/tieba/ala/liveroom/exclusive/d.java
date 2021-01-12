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
import com.baidu.live.data.aj;
import com.baidu.live.data.v;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.view.RoundRectRelativeLayout;
import com.baidu.tieba.ala.liveroom.exclusive.a;
/* loaded from: classes10.dex */
public class d extends com.baidu.live.view.e implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0662a {
    private v aGA;
    private BdGridView bJT;
    private int bSv;
    private RoundRectRelativeLayout bud;
    private float buh;
    private boolean hkI;
    private f hyA;
    private TextView hyx;
    private a hyy;
    private int hyz;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hyA = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hyz = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!Wt()) {
            Wo();
        }
    }

    public void a(v vVar, int i) {
        if (!this.mActivity.isFinishing() && vVar != null && vVar.AH()) {
            this.hyz = i;
            this.aGA = vVar;
            if (this.hyy != null) {
                this.hyy.setDatas(this.aGA.AI());
                if (this.hyz >= 0) {
                    ob(false);
                    this.hyy.vk(this.hyz);
                } else {
                    ob(true);
                    this.hyy.vk(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.bud.setCornerRadius(this.buh, 0.0f, 0.0f, this.buh);
                this.bSv = 5;
                int Wr = Wr();
                int Ws = Ws();
                setWidth(Wr);
                setHeight(Ws);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.bud);
                Ko();
            }
        }
    }

    private void ob(boolean z) {
        if (this.aGA != null) {
            c.a(this.mActivity, this.hyx, z, this.aGA.AK(), this.aGA.AJ(), false);
        }
    }

    public void Wo() {
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
        this.buh = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.bud = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hyx = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hyx.setOnClickListener(this);
        this.bJT = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hyy = new a(this.mActivity, false);
        this.hyy.a(this);
        this.bJT.setAdapter((ListAdapter) this.hyy);
        this.bud.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.bud);
    }

    private int Wr() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int Ws() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Ko() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bSv) {
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

    private boolean Wt() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hkI) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bSv) {
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
                    d.this.Wo();
                    d.this.hkI = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hkI = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void dL(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0662a
    public void a(View view, int i, aj ajVar) {
        dismiss();
        if (this.hyA != null) {
            this.hyA.a(false, view, i, ajVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hyx) {
            dismiss();
            if (this.hyA != null) {
                this.hyA.a(true, this.hyx, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
