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
    private ImageView aFi;
    private ImageView gIA;
    private TextSwitcher gIB;
    private f gID;
    private GradientDrawable gIF;
    private GradientDrawable gIG;
    private AnimatorSet gIH;
    private AnimatorSet gII;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gIC = true;
    private boolean gIE = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        t(onClickListener);
    }

    private void t(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.gIA = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.gIB = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aFi = (ImageView) this.mView.findViewById(a.f.iv_light);
        aW(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.bgr > 0) {
                    if (this.gID != null && TextUtils.equals(this.gID.aQx, fVar.aQx) && TextUtils.equals(this.gID.bgO, fVar.bgO)) {
                        if (fVar.bgr != this.gID.bgr) {
                            this.gIB.setText("Lv." + fVar.bgr + "级");
                            return;
                        }
                        return;
                    }
                    this.gID = fVar;
                    str = "Lv." + fVar.bgr + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aW(0, "");
                if (this.gIE || z) {
                    str = null;
                } else {
                    this.gIC = this.gIC ? false : true;
                    return;
                }
            }
            this.gIE = z;
            if (!TextUtils.isEmpty(str)) {
                Ht(str);
            }
        }
    }

    private Drawable bTG() {
        if (this.gIF != null) {
            return this.gIF;
        }
        this.gIF = new GradientDrawable();
        this.gIF.setShape(0);
        this.gIF.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gIF.setColors(new int[]{-10026753, -48044});
            this.gIF.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gIF;
    }

    private Drawable bTH() {
        if (this.gIG != null) {
            return this.gIG;
        }
        this.gIG = new GradientDrawable();
        this.gIG.setShape(0);
        this.gIG.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gIG.setColors(new int[]{-9549573, -831008});
            this.gIG.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gIG;
    }

    private void Ht(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gIH = new AnimatorSet();
        this.gIH.setDuration(333L);
        this.gIH.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gIH.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gII = new AnimatorSet();
        this.gII.setDuration(666L);
        this.gII.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gII.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gII.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aW(1, str);
            }
        });
        this.gIH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gII.start();
            }
        });
        this.gIH.start();
    }

    public void reset() {
        this.gIC = true;
        this.gID = null;
        this.gIE = false;
        aW(0, "");
    }

    public void onDestroy() {
        this.gIC = true;
        this.gID = null;
        this.gIE = false;
        if (this.gIH != null) {
            this.gIH.cancel();
        }
        if (this.gII != null) {
            this.gII.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bTG());
                this.gIA.setImageResource(a.e.gcb_icon_enter_not_join);
                this.gIB.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aFi.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bTH());
                this.gIA.setImageResource(a.e.gcb_icon_enter_joined);
                this.gIB.setCurrentText(str);
                this.aFi.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
