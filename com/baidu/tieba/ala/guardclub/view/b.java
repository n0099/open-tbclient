package com.baidu.tieba.ala.guardclub.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import com.baidu.live.guardclub.f;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b {
    private ImageView aUO;
    private ImageView fAC;
    private TextSwitcher fAD;
    private f fAF;
    private GradientDrawable fAH;
    private GradientDrawable fAI;
    private AnimatorSet fAJ;
    private AnimatorSet fAK;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean fAE = true;
    private boolean fAG = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        r(onClickListener);
    }

    private void r(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.fAC = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.fAD = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aUO = (ImageView) this.mView.findViewById(a.g.iv_light);
        aF(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aOz > 0) {
                    if (this.fAF != null && TextUtils.equals(this.fAF.aBs, fVar.aBs) && TextUtils.equals(this.fAF.aOW, fVar.aOW)) {
                        if (fVar.aOz != this.fAF.aOz) {
                            this.fAD.setText("Lv." + fVar.aOz + "级");
                            return;
                        }
                        return;
                    }
                    this.fAF = fVar;
                    str = "Lv." + fVar.aOz + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aF(0, "");
                if (this.fAG || z) {
                    str = null;
                } else {
                    this.fAE = this.fAE ? false : true;
                    return;
                }
            }
            this.fAG = z;
            if (!TextUtils.isEmpty(str)) {
                BU(str);
            }
        }
    }

    private Drawable bvc() {
        if (this.fAH != null) {
            return this.fAH;
        }
        this.fAH = new GradientDrawable();
        this.fAH.setShape(0);
        this.fAH.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fAH.setColors(new int[]{-10026753, -48044});
            this.fAH.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fAH;
    }

    private Drawable bvd() {
        if (this.fAI != null) {
            return this.fAI;
        }
        this.fAI = new GradientDrawable();
        this.fAI.setShape(0);
        this.fAI.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fAI.setColors(new int[]{-9549573, -831008});
            this.fAI.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fAI;
    }

    private void BU(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.fAJ = new AnimatorSet();
        this.fAJ.setDuration(333L);
        this.fAJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fAJ.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.fAK = new AnimatorSet();
        this.fAK.setDuration(666L);
        this.fAK.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fAK.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.fAK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aF(1, str);
            }
        });
        this.fAJ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.fAK.start();
            }
        });
        this.fAJ.start();
    }

    public void reset() {
        this.fAE = true;
        this.fAF = null;
        this.fAG = false;
        aF(0, "");
    }

    public void onDestroy() {
        this.fAE = true;
        this.fAF = null;
        this.fAG = false;
        if (this.fAJ != null) {
            this.fAJ.cancel();
        }
        if (this.fAK != null) {
            this.fAK.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bvc());
                this.fAC.setImageResource(a.f.gcb_icon_enter_not_join);
                this.fAD.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aUO.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bvd());
                this.fAC.setImageResource(a.f.gcb_icon_enter_joined);
                this.fAD.setCurrentText(str);
                this.aUO.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
