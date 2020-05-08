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
    private ImageView aOG;
    private ImageView fmK;
    private TextSwitcher fmL;
    private f fmN;
    private GradientDrawable fmP;
    private GradientDrawable fmQ;
    private AnimatorSet fmR;
    private AnimatorSet fmS;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean fmM = true;
    private boolean fmO = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.fmK = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.fmL = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aOG = (ImageView) this.mView.findViewById(a.g.iv_light);
        aA(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aIQ > 0) {
                    if (this.fmN != null && TextUtils.equals(this.fmN.awj, fVar.awj) && TextUtils.equals(this.fmN.aJn, fVar.aJn)) {
                        if (fVar.aIQ != this.fmN.aIQ) {
                            this.fmL.setText("Lv." + fVar.aIQ + "级");
                            return;
                        }
                        return;
                    }
                    this.fmN = fVar;
                    str = "Lv." + fVar.aIQ + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aA(0, "");
                if (this.fmO || z) {
                    str = null;
                } else {
                    this.fmM = this.fmM ? false : true;
                    return;
                }
            }
            this.fmO = z;
            if (!TextUtils.isEmpty(str)) {
                An(str);
            }
        }
    }

    private Drawable bpj() {
        if (this.fmP != null) {
            return this.fmP;
        }
        this.fmP = new GradientDrawable();
        this.fmP.setShape(0);
        this.fmP.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fmP.setColors(new int[]{-10026753, -48044});
            this.fmP.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fmP;
    }

    private Drawable bpk() {
        if (this.fmQ != null) {
            return this.fmQ;
        }
        this.fmQ = new GradientDrawable();
        this.fmQ.setShape(0);
        this.fmQ.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fmQ.setColors(new int[]{-9549573, -831008});
            this.fmQ.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fmQ;
    }

    private void An(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.fmR = new AnimatorSet();
        this.fmR.setDuration(333L);
        this.fmR.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fmR.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.fmS = new AnimatorSet();
        this.fmS.setDuration(666L);
        this.fmS.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fmS.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.fmS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aA(1, str);
            }
        });
        this.fmR.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.fmS.start();
            }
        });
        this.fmR.start();
    }

    public void reset() {
        this.fmM = true;
        this.fmN = null;
        this.fmO = false;
        aA(0, "");
    }

    public void onDestroy() {
        this.fmM = true;
        this.fmN = null;
        this.fmO = false;
        if (this.fmR != null) {
            this.fmR.cancel();
        }
        if (this.fmS != null) {
            this.fmS.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bpj());
                this.fmK.setImageResource(a.f.gcb_icon_enter_not_join);
                this.fmL.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aOG.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bpk());
                this.fmK.setImageResource(a.f.gcb_icon_enter_joined);
                this.fmL.setCurrentText(str);
                this.aOG.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
