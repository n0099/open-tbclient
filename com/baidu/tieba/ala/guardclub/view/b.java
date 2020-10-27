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
/* loaded from: classes4.dex */
public class b {
    private ImageView aEs;
    private ImageView gCM;
    private TextSwitcher gCN;
    private f gCP;
    private GradientDrawable gCR;
    private GradientDrawable gCS;
    private AnimatorSet gCT;
    private AnimatorSet gCU;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gCO = true;
    private boolean gCQ = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.gCM = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.gCN = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aEs = (ImageView) this.mView.findViewById(a.g.iv_light);
        aS(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.beW > 0) {
                    if (this.gCP != null && TextUtils.equals(this.gCP.aPA, fVar.aPA) && TextUtils.equals(this.gCP.bfu, fVar.bfu)) {
                        if (fVar.beW != this.gCP.beW) {
                            this.gCN.setText("Lv." + fVar.beW + "级");
                            return;
                        }
                        return;
                    }
                    this.gCP = fVar;
                    str = "Lv." + fVar.beW + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aS(0, "");
                if (this.gCQ || z) {
                    str = null;
                } else {
                    this.gCO = this.gCO ? false : true;
                    return;
                }
            }
            this.gCQ = z;
            if (!TextUtils.isEmpty(str)) {
                Hg(str);
            }
        }
    }

    private Drawable bRh() {
        if (this.gCR != null) {
            return this.gCR;
        }
        this.gCR = new GradientDrawable();
        this.gCR.setShape(0);
        this.gCR.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gCR.setColors(new int[]{-10026753, -48044});
            this.gCR.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gCR;
    }

    private Drawable bRi() {
        if (this.gCS != null) {
            return this.gCS;
        }
        this.gCS = new GradientDrawable();
        this.gCS.setShape(0);
        this.gCS.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gCS.setColors(new int[]{-9549573, -831008});
            this.gCS.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gCS;
    }

    private void Hg(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gCT = new AnimatorSet();
        this.gCT.setDuration(333L);
        this.gCT.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gCT.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gCU = new AnimatorSet();
        this.gCU.setDuration(666L);
        this.gCU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gCU.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gCU.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aS(1, str);
            }
        });
        this.gCT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gCU.start();
            }
        });
        this.gCT.start();
    }

    public void reset() {
        this.gCO = true;
        this.gCP = null;
        this.gCQ = false;
        aS(0, "");
    }

    public void onDestroy() {
        this.gCO = true;
        this.gCP = null;
        this.gCQ = false;
        if (this.gCT != null) {
            this.gCT.cancel();
        }
        if (this.gCU != null) {
            this.gCU.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bRh());
                this.gCM.setImageResource(a.f.gcb_icon_enter_not_join);
                this.gCN.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aEs.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bRi());
                this.gCM.setImageResource(a.f.gcb_icon_enter_joined);
                this.gCN.setCurrentText(str);
                this.aEs.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
