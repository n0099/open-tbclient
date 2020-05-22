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
    private ImageView fAr;
    private TextSwitcher fAs;
    private f fAu;
    private GradientDrawable fAw;
    private GradientDrawable fAx;
    private AnimatorSet fAy;
    private AnimatorSet fAz;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean fAt = true;
    private boolean fAv = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        r(onClickListener);
    }

    private void r(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.fAr = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.fAs = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aUO = (ImageView) this.mView.findViewById(a.g.iv_light);
        aF(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aOz > 0) {
                    if (this.fAu != null && TextUtils.equals(this.fAu.aBs, fVar.aBs) && TextUtils.equals(this.fAu.aOW, fVar.aOW)) {
                        if (fVar.aOz != this.fAu.aOz) {
                            this.fAs.setText("Lv." + fVar.aOz + "级");
                            return;
                        }
                        return;
                    }
                    this.fAu = fVar;
                    str = "Lv." + fVar.aOz + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aF(0, "");
                if (this.fAv || z) {
                    str = null;
                } else {
                    this.fAt = this.fAt ? false : true;
                    return;
                }
            }
            this.fAv = z;
            if (!TextUtils.isEmpty(str)) {
                BU(str);
            }
        }
    }

    private Drawable bva() {
        if (this.fAw != null) {
            return this.fAw;
        }
        this.fAw = new GradientDrawable();
        this.fAw.setShape(0);
        this.fAw.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fAw.setColors(new int[]{-10026753, -48044});
            this.fAw.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fAw;
    }

    private Drawable bvb() {
        if (this.fAx != null) {
            return this.fAx;
        }
        this.fAx = new GradientDrawable();
        this.fAx.setShape(0);
        this.fAx.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fAx.setColors(new int[]{-9549573, -831008});
            this.fAx.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fAx;
    }

    private void BU(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.fAy = new AnimatorSet();
        this.fAy.setDuration(333L);
        this.fAy.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fAy.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.fAz = new AnimatorSet();
        this.fAz.setDuration(666L);
        this.fAz.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fAz.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.fAz.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aF(1, str);
            }
        });
        this.fAy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.fAz.start();
            }
        });
        this.fAy.start();
    }

    public void reset() {
        this.fAt = true;
        this.fAu = null;
        this.fAv = false;
        aF(0, "");
    }

    public void onDestroy() {
        this.fAt = true;
        this.fAu = null;
        this.fAv = false;
        if (this.fAy != null) {
            this.fAy.cancel();
        }
        if (this.fAz != null) {
            this.fAz.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bva());
                this.fAr.setImageResource(a.f.gcb_icon_enter_not_join);
                this.fAs.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aUO.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bvb());
                this.fAr.setImageResource(a.f.gcb_icon_enter_joined);
                this.fAs.setCurrentText(str);
                this.aUO.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
