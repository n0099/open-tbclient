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
    private ImageView auY;
    private ImageView eIo;
    private TextSwitcher eIp;
    private f eIr;
    private GradientDrawable eIt;
    private GradientDrawable eIu;
    private AnimatorSet eIv;
    private AnimatorSet eIw;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean eIq = true;
    private boolean eIs = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.eIo = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.eIp = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.auY = (ImageView) this.mView.findViewById(a.g.iv_light);
        al(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.aqb > 0) {
                    if (this.eIr != null && TextUtils.equals(this.eIr.adM, fVar.adM) && TextUtils.equals(this.eIr.aqy, fVar.aqy)) {
                        if (fVar.aqb != this.eIr.aqb) {
                            this.eIp.setText("Lv." + fVar.aqb + "级");
                            return;
                        }
                        return;
                    }
                    this.eIr = fVar;
                    str = "Lv." + fVar.aqb + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                al(0, "");
                if (this.eIs || z) {
                    str = null;
                } else {
                    this.eIq = this.eIq ? false : true;
                    return;
                }
            }
            this.eIs = z;
            if (!TextUtils.isEmpty(str)) {
                yC(str);
            }
        }
    }

    private Drawable bfU() {
        if (this.eIt != null) {
            return this.eIt;
        }
        this.eIt = new GradientDrawable();
        this.eIt.setShape(0);
        this.eIt.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eIt.setColors(new int[]{-10026753, -48044});
            this.eIt.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eIt;
    }

    private Drawable bfV() {
        if (this.eIu != null) {
            return this.eIu;
        }
        this.eIu = new GradientDrawable();
        this.eIu.setShape(0);
        this.eIu.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eIu.setColors(new int[]{-9549573, -831008});
            this.eIu.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eIu;
    }

    private void yC(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.eIv = new AnimatorSet();
        this.eIv.setDuration(333L);
        this.eIv.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eIv.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.eIw = new AnimatorSet();
        this.eIw.setDuration(666L);
        this.eIw.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eIw.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eIw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.al(1, str);
            }
        });
        this.eIv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.eIw.start();
            }
        });
        this.eIv.start();
    }

    public void reset() {
        this.eIq = true;
        this.eIr = null;
        this.eIs = false;
        al(0, "");
    }

    public void onDestroy() {
        this.eIq = true;
        this.eIr = null;
        this.eIs = false;
        if (this.eIv != null) {
            this.eIv.cancel();
        }
        if (this.eIw != null) {
            this.eIw.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bfU());
                this.eIo.setImageResource(a.f.gcb_icon_enter_not_join);
                this.eIp.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.auY.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bfV());
                this.eIo.setImageResource(a.f.gcb_icon_enter_joined);
                this.eIp.setCurrentText(str);
                this.auY.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
