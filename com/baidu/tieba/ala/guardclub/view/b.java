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
/* loaded from: classes11.dex */
public class b {
    private ImageView aDu;
    private GradientDrawable hbA;
    private GradientDrawable hbB;
    private AnimatorSet hbC;
    private AnimatorSet hbD;
    private ImageView hbv;
    private TextSwitcher hbw;
    private f hby;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean hbx = true;
    private boolean hbz = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        u(onClickListener);
    }

    private void u(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.hbv = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.hbw = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aDu = (ImageView) this.mView.findViewById(a.f.iv_light);
        bc(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.guardLevel > 0) {
                    if (this.hby != null && TextUtils.equals(this.hby.aJM, fVar.aJM) && TextUtils.equals(this.hby.bjp, fVar.bjp)) {
                        if (fVar.guardLevel != this.hby.guardLevel) {
                            this.hbw.setText("Lv." + fVar.guardLevel + "级");
                            return;
                        }
                        return;
                    }
                    this.hby = fVar;
                    str = "Lv." + fVar.guardLevel + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                bc(0, "");
                if (this.hbz || z) {
                    str = null;
                } else {
                    this.hbx = this.hbx ? false : true;
                    return;
                }
            }
            this.hbz = z;
            if (!TextUtils.isEmpty(str)) {
                GW(str);
            }
        }
    }

    private Drawable bWj() {
        if (this.hbA != null) {
            return this.hbA;
        }
        this.hbA = new GradientDrawable();
        this.hbA.setShape(0);
        this.hbA.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hbA.setColors(new int[]{-10026753, -48044});
            this.hbA.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hbA;
    }

    private Drawable bWk() {
        if (this.hbB != null) {
            return this.hbB;
        }
        this.hbB = new GradientDrawable();
        this.hbB.setShape(0);
        this.hbB.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hbB.setColors(new int[]{-9549573, -831008});
            this.hbB.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hbB;
    }

    private void GW(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.hbC = new AnimatorSet();
        this.hbC.setDuration(333L);
        this.hbC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbC.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.hbD = new AnimatorSet();
        this.hbD.setDuration(666L);
        this.hbD.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbD.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.hbD.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.bc(1, str);
            }
        });
        this.hbC.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hbD.start();
            }
        });
        this.hbC.start();
    }

    public void reset() {
        this.hbx = true;
        this.hby = null;
        this.hbz = false;
        bc(0, "");
    }

    public void onDestroy() {
        this.hbx = true;
        this.hby = null;
        this.hbz = false;
        if (this.hbC != null) {
            this.hbC.cancel();
        }
        if (this.hbD != null) {
            this.hbD.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bWj());
                this.hbv.setImageResource(a.e.gcb_icon_enter_not_join);
                this.hbw.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aDu.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bWk());
                this.hbv.setImageResource(a.e.gcb_icon_enter_joined);
                this.hbw.setCurrentText(str);
                this.aDu.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
