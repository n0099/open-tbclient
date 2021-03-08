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
/* loaded from: classes10.dex */
public class b {
    private ImageView aEU;
    private ImageView hde;
    private TextSwitcher hdf;
    private f hdh;
    private GradientDrawable hdj;
    private GradientDrawable hdk;
    private AnimatorSet hdl;
    private AnimatorSet hdm;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean hdg = true;
    private boolean hdi = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        u(onClickListener);
    }

    private void u(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.hde = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.hdf = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aEU = (ImageView) this.mView.findViewById(a.f.iv_light);
        bc(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.guardLevel > 0) {
                    if (this.hdh != null && TextUtils.equals(this.hdh.aLm, fVar.aLm) && TextUtils.equals(this.hdh.bkP, fVar.bkP)) {
                        if (fVar.guardLevel != this.hdh.guardLevel) {
                            this.hdf.setText("Lv." + fVar.guardLevel + "级");
                            return;
                        }
                        return;
                    }
                    this.hdh = fVar;
                    str = "Lv." + fVar.guardLevel + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                bc(0, "");
                if (this.hdi || z) {
                    str = null;
                } else {
                    this.hdg = this.hdg ? false : true;
                    return;
                }
            }
            this.hdi = z;
            if (!TextUtils.isEmpty(str)) {
                Hf(str);
            }
        }
    }

    private Drawable bWp() {
        if (this.hdj != null) {
            return this.hdj;
        }
        this.hdj = new GradientDrawable();
        this.hdj.setShape(0);
        this.hdj.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hdj.setColors(new int[]{-10026753, -48044});
            this.hdj.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hdj;
    }

    private Drawable bWq() {
        if (this.hdk != null) {
            return this.hdk;
        }
        this.hdk = new GradientDrawable();
        this.hdk.setShape(0);
        this.hdk.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hdk.setColors(new int[]{-9549573, -831008});
            this.hdk.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hdk;
    }

    private void Hf(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.hdl = new AnimatorSet();
        this.hdl.setDuration(333L);
        this.hdl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hdl.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.hdm = new AnimatorSet();
        this.hdm.setDuration(666L);
        this.hdm.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hdm.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.hdm.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.bc(1, str);
            }
        });
        this.hdl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hdm.start();
            }
        });
        this.hdl.start();
    }

    public void reset() {
        this.hdg = true;
        this.hdh = null;
        this.hdi = false;
        bc(0, "");
    }

    public void onDestroy() {
        this.hdg = true;
        this.hdh = null;
        this.hdi = false;
        if (this.hdl != null) {
            this.hdl.cancel();
        }
        if (this.hdm != null) {
            this.hdm.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bWp());
                this.hde.setImageResource(a.e.gcb_icon_enter_not_join);
                this.hdf.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aEU.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bWq());
                this.hde.setImageResource(a.e.gcb_icon_enter_joined);
                this.hdf.setCurrentText(str);
                this.aEU.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
