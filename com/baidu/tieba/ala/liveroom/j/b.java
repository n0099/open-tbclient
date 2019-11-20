package com.baidu.tieba.ala.liveroom.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.guardclub.model.k;
/* loaded from: classes6.dex */
public class b {
    private ImageView aio;
    private ImageView efW;
    private TextSwitcher efX;
    private k efZ;
    private GradientDrawable egb;
    private GradientDrawable egc;
    private AnimatorSet egd;
    private AnimatorSet ege;
    private boolean isHost;
    private TbPageContext mContext;
    private View mView;
    private boolean efY = true;
    private boolean ega = false;

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        this.isHost = z;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.efW = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.efX = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aio = (ImageView) this.mView.findViewById(a.g.iv_light);
        aa(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, k kVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (kVar != null && kVar.dNl > 0) {
                    if (this.efZ != null && TextUtils.equals(this.efZ.dND, kVar.dND) && TextUtils.equals(this.efZ.dNQ, kVar.dNQ)) {
                        if (kVar.dNl != this.efZ.dNl) {
                            this.efX.setText("Lv." + kVar.dNl + "级");
                            return;
                        }
                        return;
                    }
                    this.efZ = kVar;
                    str = "Lv." + kVar.dNl + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aa(0, "");
                if (this.ega || z) {
                    str = null;
                } else {
                    this.efY = this.efY ? false : true;
                    return;
                }
            }
            this.ega = z;
            if (!TextUtils.isEmpty(str)) {
                tK(str);
            }
        }
    }

    private Drawable aRY() {
        if (this.egb != null) {
            return this.egb;
        }
        this.egb = new GradientDrawable();
        this.egb.setShape(0);
        this.egb.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.egb.setColors(new int[]{-10026753, -48044});
            this.egb.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.egb;
    }

    private Drawable aRZ() {
        if (this.egc != null) {
            return this.egc;
        }
        this.egc = new GradientDrawable();
        this.egc.setShape(0);
        this.egc.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.egc.setColors(new int[]{-9549573, -831008});
            this.egc.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.egc;
    }

    private void tK(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.egd = new AnimatorSet();
        this.egd.setDuration(333L);
        this.egd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.egd.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.ege = new AnimatorSet();
        this.ege.setDuration(666L);
        this.ege.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ege.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.ege.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aa(1, str);
            }
        });
        this.egd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.ege.start();
            }
        });
        this.egd.start();
    }

    public void reset() {
        this.efY = true;
        this.efZ = null;
        this.ega = false;
        aa(0, "");
    }

    public void onDestroy() {
        this.efY = true;
        this.efZ = null;
        this.ega = false;
        if (this.egd != null) {
            this.egd.cancel();
        }
        if (this.ege != null) {
            this.ege.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(aRY());
                this.efW.setImageResource(a.f.gcb_icon_enter_not_join);
                this.efX.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aio.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(aRZ());
                this.efW.setImageResource(a.f.gcb_icon_enter_joined);
                this.efX.setCurrentText(str);
                this.aio.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
