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
    private ImageView aOA;
    private ImageView fmF;
    private TextSwitcher fmG;
    private f fmI;
    private GradientDrawable fmK;
    private GradientDrawable fmL;
    private AnimatorSet fmM;
    private AnimatorSet fmN;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean fmH = true;
    private boolean fmJ = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.fmF = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.fmG = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aOA = (ImageView) this.mView.findViewById(a.g.iv_light);
        aA(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aIK > 0) {
                    if (this.fmI != null && TextUtils.equals(this.fmI.awd, fVar.awd) && TextUtils.equals(this.fmI.aJh, fVar.aJh)) {
                        if (fVar.aIK != this.fmI.aIK) {
                            this.fmG.setText("Lv." + fVar.aIK + "级");
                            return;
                        }
                        return;
                    }
                    this.fmI = fVar;
                    str = "Lv." + fVar.aIK + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aA(0, "");
                if (this.fmJ || z) {
                    str = null;
                } else {
                    this.fmH = this.fmH ? false : true;
                    return;
                }
            }
            this.fmJ = z;
            if (!TextUtils.isEmpty(str)) {
                Ak(str);
            }
        }
    }

    private Drawable bpl() {
        if (this.fmK != null) {
            return this.fmK;
        }
        this.fmK = new GradientDrawable();
        this.fmK.setShape(0);
        this.fmK.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fmK.setColors(new int[]{-10026753, -48044});
            this.fmK.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fmK;
    }

    private Drawable bpm() {
        if (this.fmL != null) {
            return this.fmL;
        }
        this.fmL = new GradientDrawable();
        this.fmL.setShape(0);
        this.fmL.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fmL.setColors(new int[]{-9549573, -831008});
            this.fmL.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fmL;
    }

    private void Ak(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.fmM = new AnimatorSet();
        this.fmM.setDuration(333L);
        this.fmM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fmM.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.fmN = new AnimatorSet();
        this.fmN.setDuration(666L);
        this.fmN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fmN.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.fmN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aA(1, str);
            }
        });
        this.fmM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.fmN.start();
            }
        });
        this.fmM.start();
    }

    public void reset() {
        this.fmH = true;
        this.fmI = null;
        this.fmJ = false;
        aA(0, "");
    }

    public void onDestroy() {
        this.fmH = true;
        this.fmI = null;
        this.fmJ = false;
        if (this.fmM != null) {
            this.fmM.cancel();
        }
        if (this.fmN != null) {
            this.fmN.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bpl());
                this.fmF.setImageResource(a.f.gcb_icon_enter_not_join);
                this.fmG.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aOA.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bpm());
                this.fmF.setImageResource(a.f.gcb_icon_enter_joined);
                this.fmG.setCurrentText(str);
                this.aOA.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
