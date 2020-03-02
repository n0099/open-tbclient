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
    private ImageView eHF;
    private TextSwitcher eHG;
    private f eHI;
    private GradientDrawable eHK;
    private GradientDrawable eHL;
    private AnimatorSet eHM;
    private AnimatorSet eHN;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean eHH = true;
    private boolean eHJ = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.eHF = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.eHG = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.auN = (ImageView) this.mView.findViewById(a.g.iv_light);
        al(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.apQ > 0) {
                    if (this.eHI != null && TextUtils.equals(this.eHI.adC, fVar.adC) && TextUtils.equals(this.eHI.aqn, fVar.aqn)) {
                        if (fVar.apQ != this.eHI.apQ) {
                            this.eHG.setText("Lv." + fVar.apQ + "级");
                            return;
                        }
                        return;
                    }
                    this.eHI = fVar;
                    str = "Lv." + fVar.apQ + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                al(0, "");
                if (this.eHJ || z) {
                    str = null;
                } else {
                    this.eHH = this.eHH ? false : true;
                    return;
                }
            }
            this.eHJ = z;
            if (!TextUtils.isEmpty(str)) {
                yA(str);
            }
        }
    }

    private Drawable bfO() {
        if (this.eHK != null) {
            return this.eHK;
        }
        this.eHK = new GradientDrawable();
        this.eHK.setShape(0);
        this.eHK.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eHK.setColors(new int[]{-10026753, -48044});
            this.eHK.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eHK;
    }

    private Drawable bfP() {
        if (this.eHL != null) {
            return this.eHL;
        }
        this.eHL = new GradientDrawable();
        this.eHL.setShape(0);
        this.eHL.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eHL.setColors(new int[]{-9549573, -831008});
            this.eHL.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eHL;
    }

    private void yA(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.eHM = new AnimatorSet();
        this.eHM.setDuration(333L);
        this.eHM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eHM.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.eHN = new AnimatorSet();
        this.eHN.setDuration(666L);
        this.eHN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eHN.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eHN.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.al(1, str);
            }
        });
        this.eHM.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.eHN.start();
            }
        });
        this.eHM.start();
    }

    public void reset() {
        this.eHH = true;
        this.eHI = null;
        this.eHJ = false;
        al(0, "");
    }

    public void onDestroy() {
        this.eHH = true;
        this.eHI = null;
        this.eHJ = false;
        if (this.eHM != null) {
            this.eHM.cancel();
        }
        if (this.eHN != null) {
            this.eHN.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bfO());
                this.eHF.setImageResource(a.f.gcb_icon_enter_not_join);
                this.eHG.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.auN.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bfP());
                this.eHF.setImageResource(a.f.gcb_icon_enter_joined);
                this.eHG.setCurrentText(str);
                this.auN.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
