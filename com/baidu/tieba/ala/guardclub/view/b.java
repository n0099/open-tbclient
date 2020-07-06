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
import com.baidu.live.sdk.a;
/* loaded from: classes3.dex */
public class b {
    private ImageView aXv;
    private ImageView fLL;
    private TextSwitcher fLM;
    private f fLO;
    private GradientDrawable fLQ;
    private GradientDrawable fLR;
    private AnimatorSet fLS;
    private AnimatorSet fLT;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean fLN = true;
    private boolean fLP = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.fLL = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.fLM = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aXv = (ImageView) this.mView.findViewById(a.g.iv_light);
        aH(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aRf > 0) {
                    if (this.fLO != null && TextUtils.equals(this.fLO.aDD, fVar.aDD) && TextUtils.equals(this.fLO.aRC, fVar.aRC)) {
                        if (fVar.aRf != this.fLO.aRf) {
                            this.fLM.setText("Lv." + fVar.aRf + "级");
                            return;
                        }
                        return;
                    }
                    this.fLO = fVar;
                    str = "Lv." + fVar.aRf + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aH(0, "");
                if (this.fLP || z) {
                    str = null;
                } else {
                    this.fLN = this.fLN ? false : true;
                    return;
                }
            }
            this.fLP = z;
            if (!TextUtils.isEmpty(str)) {
                Cs(str);
            }
        }
    }

    private Drawable bxY() {
        if (this.fLQ != null) {
            return this.fLQ;
        }
        this.fLQ = new GradientDrawable();
        this.fLQ.setShape(0);
        this.fLQ.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fLQ.setColors(new int[]{-10026753, -48044});
            this.fLQ.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fLQ;
    }

    private Drawable bxZ() {
        if (this.fLR != null) {
            return this.fLR;
        }
        this.fLR = new GradientDrawable();
        this.fLR.setShape(0);
        this.fLR.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fLR.setColors(new int[]{-9549573, -831008});
            this.fLR.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fLR;
    }

    private void Cs(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.fLS = new AnimatorSet();
        this.fLS.setDuration(333L);
        this.fLS.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fLS.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.fLT = new AnimatorSet();
        this.fLT.setDuration(666L);
        this.fLT.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fLT.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.fLT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aH(1, str);
            }
        });
        this.fLS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.fLT.start();
            }
        });
        this.fLS.start();
    }

    public void reset() {
        this.fLN = true;
        this.fLO = null;
        this.fLP = false;
        aH(0, "");
    }

    public void onDestroy() {
        this.fLN = true;
        this.fLO = null;
        this.fLP = false;
        if (this.fLS != null) {
            this.fLS.cancel();
        }
        if (this.fLT != null) {
            this.fLT.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bxY());
                this.fLL.setImageResource(a.f.gcb_icon_enter_not_join);
                this.fLM.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aXv.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bxZ());
                this.fLL.setImageResource(a.f.gcb_icon_enter_joined);
                this.fLM.setCurrentText(str);
                this.aXv.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
