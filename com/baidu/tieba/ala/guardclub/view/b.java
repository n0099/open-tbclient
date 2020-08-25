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
/* loaded from: classes7.dex */
public class b {
    private ImageView aAx;
    private ImageView gdd;
    private TextSwitcher gde;
    private f gdg;
    private GradientDrawable gdi;
    private GradientDrawable gdj;
    private AnimatorSet gdk;
    private AnimatorSet gdl;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gdf = true;
    private boolean gdh = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.gdd = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.gde = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aAx = (ImageView) this.mView.findViewById(a.g.iv_light);
        aH(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aXM > 0) {
                    if (this.gdg != null && TextUtils.equals(this.gdg.aKh, fVar.aKh) && TextUtils.equals(this.gdg.aYj, fVar.aYj)) {
                        if (fVar.aXM != this.gdg.aXM) {
                            this.gde.setText("Lv." + fVar.aXM + "级");
                            return;
                        }
                        return;
                    }
                    this.gdg = fVar;
                    str = "Lv." + fVar.aXM + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aH(0, "");
                if (this.gdh || z) {
                    str = null;
                } else {
                    this.gdf = this.gdf ? false : true;
                    return;
                }
            }
            this.gdh = z;
            if (!TextUtils.isEmpty(str)) {
                Fz(str);
            }
        }
    }

    private Drawable bKH() {
        if (this.gdi != null) {
            return this.gdi;
        }
        this.gdi = new GradientDrawable();
        this.gdi.setShape(0);
        this.gdi.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gdi.setColors(new int[]{-10026753, -48044});
            this.gdi.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gdi;
    }

    private Drawable bKI() {
        if (this.gdj != null) {
            return this.gdj;
        }
        this.gdj = new GradientDrawable();
        this.gdj.setShape(0);
        this.gdj.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gdj.setColors(new int[]{-9549573, -831008});
            this.gdj.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gdj;
    }

    private void Fz(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gdk = new AnimatorSet();
        this.gdk.setDuration(333L);
        this.gdk.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdk.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gdl = new AnimatorSet();
        this.gdl.setDuration(666L);
        this.gdl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdl.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gdl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aH(1, str);
            }
        });
        this.gdk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gdl.start();
            }
        });
        this.gdk.start();
    }

    public void reset() {
        this.gdf = true;
        this.gdg = null;
        this.gdh = false;
        aH(0, "");
    }

    public void onDestroy() {
        this.gdf = true;
        this.gdg = null;
        this.gdh = false;
        if (this.gdk != null) {
            this.gdk.cancel();
        }
        if (this.gdl != null) {
            this.gdl.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bKH());
                this.gdd.setImageResource(a.f.gcb_icon_enter_not_join);
                this.gde.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aAx.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bKI());
                this.gdd.setImageResource(a.f.gcb_icon_enter_joined);
                this.gde.setCurrentText(str);
                this.aAx.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
