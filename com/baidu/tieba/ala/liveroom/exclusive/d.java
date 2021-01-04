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
/* loaded from: classes11.dex */
public class d extends com.baidu.live.view.e implements View.OnClickListener, com.baidu.live.view.web.f, a.InterfaceC0679a {
    private v aLn;
    private BdGridView bOF;
    private int bXh;
    private RoundRectRelativeLayout byQ;
    private float byT;
    private TextView hDd;
    private a hDe;
    private int hDf;
    private f hDg;
    private boolean hpp;
    private Activity mActivity;
    private View mRootView;

    public void a(f fVar) {
        this.hDg = fVar;
    }

    public d(Activity activity) {
        super(activity);
        this.hDf = -1;
        this.mActivity = activity;
        init();
    }

    @Override // com.baidu.live.view.e, android.widget.PopupWindow
    public void dismiss() {
        if (!aal()) {
            aag();
        }
    }

    public void a(v vVar, int i) {
        if (!this.mActivity.isFinishing() && vVar != null && vVar.EC()) {
            this.hDf = i;
            this.aLn = vVar;
            if (this.hDe != null) {
                this.hDe.setDatas(this.aLn.ED());
                if (this.hDf >= 0) {
                    of(false);
                    this.hDe.wQ(this.hDf);
                } else {
                    of(true);
                    this.hDe.wQ(-1);
                }
            }
            View findViewById = this.mActivity.getWindow().getDecorView().findViewById(16908290);
            if (findViewById != null) {
                this.byQ.setCornerRadius(this.byT, 0.0f, 0.0f, this.byT);
                this.bXh = 5;
                int aaj = aaj();
                int aak = aak();
                setWidth(aaj);
                setHeight(aak);
                showAtLocation(findViewById, 85, 0, 0);
                ah(this.byQ);
                Oj();
            }
        }
    }

    private void of(boolean z) {
        if (this.aLn != null) {
            c.a(this.mActivity, this.hDd, z, this.aLn.EF(), this.aLn.EE(), false);
        }
    }

    public void aag() {
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
        this.byT = this.mActivity.getResources().getDimensionPixelOffset(a.d.sdk_ds36);
        this.byQ = new RoundRectRelativeLayout(this.mActivity);
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(a.g.ala_exclusive_scene_land_pop_layout, (ViewGroup) null);
        this.hDd = (TextView) this.mRootView.findViewById(a.f.tv_land_allscene);
        this.hDd.setOnClickListener(this);
        this.bOF = (BdGridView) this.mRootView.findViewById(a.f.ala_live_land_scene_gridview);
        this.hDe = new a(this.mActivity, false);
        this.hDe.a(this);
        this.bOF.setAdapter((ListAdapter) this.hDe);
        this.byQ.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.byQ);
    }

    private int aaj() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private int aak() {
        return ScreenHelper.getRealScreenHeight(this.mActivity);
    }

    private void Oj() {
        if (getContentView() != null) {
            TranslateAnimation translateAnimation = null;
            switch (this.bXh) {
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

    private boolean aal() {
        if (getContentView() == null) {
            return false;
        }
        if (this.hpp) {
            return true;
        }
        TranslateAnimation translateAnimation = null;
        switch (this.bXh) {
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
                    d.this.aag();
                    d.this.hpp = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            getContentView().startAnimation(translateAnimation);
            this.hpp = true;
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.view.web.f
    public void fr(int i) {
        dismiss();
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0679a
    public void a(View view, int i, aj ajVar) {
        dismiss();
        if (this.hDg != null) {
            this.hDg.a(false, view, i, ajVar);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hDd) {
            dismiss();
            if (this.hDg != null) {
                this.hDg.a(true, this.hDd, -1, null);
            }
        }
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5380);
        }
    }
}
