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
    private ImageView aAz;
    private ImageView gdh;
    private TextSwitcher gdi;
    private f gdk;
    private GradientDrawable gdm;
    private GradientDrawable gdn;
    private AnimatorSet gdo;
    private AnimatorSet gdp;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gdj = true;
    private boolean gdl = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.gdh = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.gdi = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aAz = (ImageView) this.mView.findViewById(a.g.iv_light);
        aG(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aXO > 0) {
                    if (this.gdk != null && TextUtils.equals(this.gdk.aKj, fVar.aKj) && TextUtils.equals(this.gdk.aYl, fVar.aYl)) {
                        if (fVar.aXO != this.gdk.aXO) {
                            this.gdi.setText("Lv." + fVar.aXO + "级");
                            return;
                        }
                        return;
                    }
                    this.gdk = fVar;
                    str = "Lv." + fVar.aXO + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aG(0, "");
                if (this.gdl || z) {
                    str = null;
                } else {
                    this.gdj = this.gdj ? false : true;
                    return;
                }
            }
            this.gdl = z;
            if (!TextUtils.isEmpty(str)) {
                FA(str);
            }
        }
    }

    private Drawable bKI() {
        if (this.gdm != null) {
            return this.gdm;
        }
        this.gdm = new GradientDrawable();
        this.gdm.setShape(0);
        this.gdm.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gdm.setColors(new int[]{-10026753, -48044});
            this.gdm.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gdm;
    }

    private Drawable bKJ() {
        if (this.gdn != null) {
            return this.gdn;
        }
        this.gdn = new GradientDrawable();
        this.gdn.setShape(0);
        this.gdn.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gdn.setColors(new int[]{-9549573, -831008});
            this.gdn.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gdn;
    }

    private void FA(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gdo = new AnimatorSet();
        this.gdo.setDuration(333L);
        this.gdo.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdo.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gdp = new AnimatorSet();
        this.gdp.setDuration(666L);
        this.gdp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdp.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gdp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aG(1, str);
            }
        });
        this.gdo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gdp.start();
            }
        });
        this.gdo.start();
    }

    public void reset() {
        this.gdj = true;
        this.gdk = null;
        this.gdl = false;
        aG(0, "");
    }

    public void onDestroy() {
        this.gdj = true;
        this.gdk = null;
        this.gdl = false;
        if (this.gdo != null) {
            this.gdo.cancel();
        }
        if (this.gdp != null) {
            this.gdp.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bKI());
                this.gdh.setImageResource(a.f.gcb_icon_enter_not_join);
                this.gdi.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aAz.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bKJ());
                this.gdh.setImageResource(a.f.gcb_icon_enter_joined);
                this.gdi.setCurrentText(str);
                this.aAz.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
