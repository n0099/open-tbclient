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
    private ImageView auN;
    private ImageView eHE;
    private TextSwitcher eHF;
    private f eHH;
    private GradientDrawable eHJ;
    private GradientDrawable eHK;
    private AnimatorSet eHL;
    private AnimatorSet eHM;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean eHG = true;
    private boolean eHI = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.eHE = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.eHF = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.auN = (ImageView) this.mView.findViewById(a.g.iv_light);
        al(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.apQ > 0) {
                    if (this.eHH != null && TextUtils.equals(this.eHH.adC, fVar.adC) && TextUtils.equals(this.eHH.aqn, fVar.aqn)) {
                        if (fVar.apQ != this.eHH.apQ) {
                            this.eHF.setText("Lv." + fVar.apQ + "级");
                            return;
                        }
                        return;
                    }
                    this.eHH = fVar;
                    str = "Lv." + fVar.apQ + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                al(0, "");
                if (this.eHI || z) {
                    str = null;
                } else {
                    this.eHG = this.eHG ? false : true;
                    return;
                }
            }
            this.eHI = z;
            if (!TextUtils.isEmpty(str)) {
                yA(str);
            }
        }
    }

    private Drawable bfM() {
        if (this.eHJ != null) {
            return this.eHJ;
        }
        this.eHJ = new GradientDrawable();
        this.eHJ.setShape(0);
        this.eHJ.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eHJ.setColors(new int[]{-10026753, -48044});
            this.eHJ.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eHJ;
    }

    private Drawable bfN() {
        if (this.eHK != null) {
            return this.eHK;
        }
        this.eHK = new GradientDrawable();
        this.eHK.setShape(0);
        this.eHK.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eHK.setColors(new int[]{-9549573, -831008});
            this.eHK.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eHK;
    }

    private void yA(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.eHL = new AnimatorSet();
        this.eHL.setDuration(333L);
        this.eHL.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eHL.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.eHM = new AnimatorSet();
        this.eHM.setDuration(666L);
        this.eHM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eHM.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eHM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.al(1, str);
            }
        });
        this.eHL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.eHM.start();
            }
        });
        this.eHL.start();
    }

    public void reset() {
        this.eHG = true;
        this.eHH = null;
        this.eHI = false;
        al(0, "");
    }

    public void onDestroy() {
        this.eHG = true;
        this.eHH = null;
        this.eHI = false;
        if (this.eHL != null) {
            this.eHL.cancel();
        }
        if (this.eHM != null) {
            this.eHM.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bfM());
                this.eHE.setImageResource(a.f.gcb_icon_enter_not_join);
                this.eHF.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.auN.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bfN());
                this.eHE.setImageResource(a.f.gcb_icon_enter_joined);
                this.eHF.setCurrentText(str);
                this.auN.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
