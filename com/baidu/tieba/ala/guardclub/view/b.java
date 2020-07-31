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
    private ImageView avv;
    private ImageView fRf;
    private TextSwitcher fRg;
    private f fRi;
    private GradientDrawable fRk;
    private GradientDrawable fRl;
    private AnimatorSet fRm;
    private AnimatorSet fRn;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean fRh = true;
    private boolean fRj = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.fRf = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.fRg = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.avv = (ImageView) this.mView.findViewById(a.g.iv_light);
        aJ(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aSy > 0) {
                    if (this.fRi != null && TextUtils.equals(this.fRi.aEX, fVar.aEX) && TextUtils.equals(this.fRi.aSV, fVar.aSV)) {
                        if (fVar.aSy != this.fRi.aSy) {
                            this.fRg.setText("Lv." + fVar.aSy + "级");
                            return;
                        }
                        return;
                    }
                    this.fRi = fVar;
                    str = "Lv." + fVar.aSy + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aJ(0, "");
                if (this.fRj || z) {
                    str = null;
                } else {
                    this.fRh = this.fRh ? false : true;
                    return;
                }
            }
            this.fRj = z;
            if (!TextUtils.isEmpty(str)) {
                De(str);
            }
        }
    }

    private Drawable bBn() {
        if (this.fRk != null) {
            return this.fRk;
        }
        this.fRk = new GradientDrawable();
        this.fRk.setShape(0);
        this.fRk.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fRk.setColors(new int[]{-10026753, -48044});
            this.fRk.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fRk;
    }

    private Drawable bBo() {
        if (this.fRl != null) {
            return this.fRl;
        }
        this.fRl = new GradientDrawable();
        this.fRl.setShape(0);
        this.fRl.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.fRl.setColors(new int[]{-9549573, -831008});
            this.fRl.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.fRl;
    }

    private void De(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.fRm = new AnimatorSet();
        this.fRm.setDuration(333L);
        this.fRm.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fRm.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.fRn = new AnimatorSet();
        this.fRn.setDuration(666L);
        this.fRn.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fRn.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.fRn.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aJ(1, str);
            }
        });
        this.fRm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.fRn.start();
            }
        });
        this.fRm.start();
    }

    public void reset() {
        this.fRh = true;
        this.fRi = null;
        this.fRj = false;
        aJ(0, "");
    }

    public void onDestroy() {
        this.fRh = true;
        this.fRi = null;
        this.fRj = false;
        if (this.fRm != null) {
            this.fRm.cancel();
        }
        if (this.fRn != null) {
            this.fRn.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bBn());
                this.fRf.setImageResource(a.f.gcb_icon_enter_not_join);
                this.fRg.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.avv.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bBo());
                this.fRf.setImageResource(a.f.gcb_icon_enter_joined);
                this.fRg.setCurrentText(str);
                this.avv.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
