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
    private ImageView aDx;
    private ImageView gIh;
    private TextSwitcher gIi;
    private f gIk;
    private GradientDrawable gIm;
    private GradientDrawable gIn;
    private AnimatorSet gIo;
    private AnimatorSet gIp;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gIj = true;
    private boolean gIl = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        t(onClickListener);
    }

    private void t(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.gIh = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.gIi = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aDx = (ImageView) this.mView.findViewById(a.f.iv_light);
        aU(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.beE > 0) {
                    if (this.gIk != null && TextUtils.equals(this.gIk.aOM, fVar.aOM) && TextUtils.equals(this.gIk.bfa, fVar.bfa)) {
                        if (fVar.beE != this.gIk.beE) {
                            this.gIi.setText("Lv." + fVar.beE + "级");
                            return;
                        }
                        return;
                    }
                    this.gIk = fVar;
                    str = "Lv." + fVar.beE + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aU(0, "");
                if (this.gIl || z) {
                    str = null;
                } else {
                    this.gIj = this.gIj ? false : true;
                    return;
                }
            }
            this.gIl = z;
            if (!TextUtils.isEmpty(str)) {
                GU(str);
            }
        }
    }

    private Drawable bSZ() {
        if (this.gIm != null) {
            return this.gIm;
        }
        this.gIm = new GradientDrawable();
        this.gIm.setShape(0);
        this.gIm.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gIm.setColors(new int[]{-10026753, -48044});
            this.gIm.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gIm;
    }

    private Drawable bTa() {
        if (this.gIn != null) {
            return this.gIn;
        }
        this.gIn = new GradientDrawable();
        this.gIn.setShape(0);
        this.gIn.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gIn.setColors(new int[]{-9549573, -831008});
            this.gIn.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gIn;
    }

    private void GU(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gIo = new AnimatorSet();
        this.gIo.setDuration(333L);
        this.gIo.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gIo.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gIp = new AnimatorSet();
        this.gIp.setDuration(666L);
        this.gIp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gIp.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gIp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aU(1, str);
            }
        });
        this.gIo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gIp.start();
            }
        });
        this.gIo.start();
    }

    public void reset() {
        this.gIj = true;
        this.gIk = null;
        this.gIl = false;
        aU(0, "");
    }

    public void onDestroy() {
        this.gIj = true;
        this.gIk = null;
        this.gIl = false;
        if (this.gIo != null) {
            this.gIo.cancel();
        }
        if (this.gIp != null) {
            this.gIp.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bSZ());
                this.gIh.setImageResource(a.e.gcb_icon_enter_not_join);
                this.gIi.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aDx.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bTa());
                this.gIh.setImageResource(a.e.gcb_icon_enter_joined);
                this.gIi.setCurrentText(str);
                this.aDx.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
