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
    private ImageView auO;
    private ImageView eHS;
    private TextSwitcher eHT;
    private f eHV;
    private GradientDrawable eHX;
    private GradientDrawable eHY;
    private AnimatorSet eHZ;
    private AnimatorSet eIa;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean eHU = true;
    private boolean eHW = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.eHS = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.eHT = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.auO = (ImageView) this.mView.findViewById(a.g.iv_light);
        al(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.apR > 0) {
                    if (this.eHV != null && TextUtils.equals(this.eHV.adC, fVar.adC) && TextUtils.equals(this.eHV.aqo, fVar.aqo)) {
                        if (fVar.apR != this.eHV.apR) {
                            this.eHT.setText("Lv." + fVar.apR + "级");
                            return;
                        }
                        return;
                    }
                    this.eHV = fVar;
                    str = "Lv." + fVar.apR + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                al(0, "");
                if (this.eHW || z) {
                    str = null;
                } else {
                    this.eHU = this.eHU ? false : true;
                    return;
                }
            }
            this.eHW = z;
            if (!TextUtils.isEmpty(str)) {
                yB(str);
            }
        }
    }

    private Drawable bfP() {
        if (this.eHX != null) {
            return this.eHX;
        }
        this.eHX = new GradientDrawable();
        this.eHX.setShape(0);
        this.eHX.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eHX.setColors(new int[]{-10026753, -48044});
            this.eHX.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eHX;
    }

    private Drawable bfQ() {
        if (this.eHY != null) {
            return this.eHY;
        }
        this.eHY = new GradientDrawable();
        this.eHY.setShape(0);
        this.eHY.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eHY.setColors(new int[]{-9549573, -831008});
            this.eHY.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eHY;
    }

    private void yB(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.eHZ = new AnimatorSet();
        this.eHZ.setDuration(333L);
        this.eHZ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eHZ.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.eIa = new AnimatorSet();
        this.eIa.setDuration(666L);
        this.eIa.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eIa.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eIa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.al(1, str);
            }
        });
        this.eHZ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.eIa.start();
            }
        });
        this.eHZ.start();
    }

    public void reset() {
        this.eHU = true;
        this.eHV = null;
        this.eHW = false;
        al(0, "");
    }

    public void onDestroy() {
        this.eHU = true;
        this.eHV = null;
        this.eHW = false;
        if (this.eHZ != null) {
            this.eHZ.cancel();
        }
        if (this.eIa != null) {
            this.eIa.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bfP());
                this.eHS.setImageResource(a.f.gcb_icon_enter_not_join);
                this.eHT.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.auO.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bfQ());
                this.eHS.setImageResource(a.f.gcb_icon_enter_joined);
                this.eHT.setCurrentText(str);
                this.auO.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
