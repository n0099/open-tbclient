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
    private ImageView hbh;
    private TextSwitcher hbi;
    private f hbk;
    private GradientDrawable hbm;
    private GradientDrawable hbn;
    private AnimatorSet hbo;
    private AnimatorSet hbp;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean hbj = true;
    private boolean hbl = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        u(onClickListener);
    }

    private void u(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.hbh = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.hbi = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aDu = (ImageView) this.mView.findViewById(a.f.iv_light);
        bc(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.guardLevel > 0) {
                    if (this.hbk != null && TextUtils.equals(this.hbk.aJM, fVar.aJM) && TextUtils.equals(this.hbk.bjp, fVar.bjp)) {
                        if (fVar.guardLevel != this.hbk.guardLevel) {
                            this.hbi.setText("Lv." + fVar.guardLevel + "级");
                            return;
                        }
                        return;
                    }
                    this.hbk = fVar;
                    str = "Lv." + fVar.guardLevel + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                bc(0, "");
                if (this.hbl || z) {
                    str = null;
                } else {
                    this.hbj = this.hbj ? false : true;
                    return;
                }
            }
            this.hbl = z;
            if (!TextUtils.isEmpty(str)) {
                GV(str);
            }
        }
    }

    private Drawable bWc() {
        if (this.hbm != null) {
            return this.hbm;
        }
        this.hbm = new GradientDrawable();
        this.hbm.setShape(0);
        this.hbm.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hbm.setColors(new int[]{-10026753, -48044});
            this.hbm.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hbm;
    }

    private Drawable bWd() {
        if (this.hbn != null) {
            return this.hbn;
        }
        this.hbn = new GradientDrawable();
        this.hbn.setShape(0);
        this.hbn.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hbn.setColors(new int[]{-9549573, -831008});
            this.hbn.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hbn;
    }

    private void GV(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.hbo = new AnimatorSet();
        this.hbo.setDuration(333L);
        this.hbo.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbo.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.hbp = new AnimatorSet();
        this.hbp.setDuration(666L);
        this.hbp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hbp.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.hbp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.bc(1, str);
            }
        });
        this.hbo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hbp.start();
            }
        });
        this.hbo.start();
    }

    public void reset() {
        this.hbj = true;
        this.hbk = null;
        this.hbl = false;
        bc(0, "");
    }

    public void onDestroy() {
        this.hbj = true;
        this.hbk = null;
        this.hbl = false;
        if (this.hbo != null) {
            this.hbo.cancel();
        }
        if (this.hbp != null) {
            this.hbp.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bWc());
                this.hbh.setImageResource(a.e.gcb_icon_enter_not_join);
                this.hbi.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aDu.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bWd());
                this.hbh.setImageResource(a.e.gcb_icon_enter_joined);
                this.hbi.setCurrentText(str);
                this.aDu.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
