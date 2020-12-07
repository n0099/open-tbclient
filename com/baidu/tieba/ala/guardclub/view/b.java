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
    private ImageView aGd;
    private ImageView gRo;
    private TextSwitcher gRp;
    private f gRr;
    private GradientDrawable gRt;
    private GradientDrawable gRu;
    private AnimatorSet gRv;
    private AnimatorSet gRw;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gRq = true;
    private boolean gRs = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        t(onClickListener);
    }

    private void t(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.gRo = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.gRp = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aGd = (ImageView) this.mView.findViewById(a.f.iv_light);
        aU(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.guardLevel > 0) {
                    if (this.gRr != null && TextUtils.equals(this.gRr.aRO, fVar.aRO) && TextUtils.equals(this.gRr.bjr, fVar.bjr)) {
                        if (fVar.guardLevel != this.gRr.guardLevel) {
                            this.gRp.setText("Lv." + fVar.guardLevel + "级");
                            return;
                        }
                        return;
                    }
                    this.gRr = fVar;
                    str = "Lv." + fVar.guardLevel + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aU(0, "");
                if (this.gRs || z) {
                    str = null;
                } else {
                    this.gRq = this.gRq ? false : true;
                    return;
                }
            }
            this.gRs = z;
            if (!TextUtils.isEmpty(str)) {
                HI(str);
            }
        }
    }

    private Drawable bWJ() {
        if (this.gRt != null) {
            return this.gRt;
        }
        this.gRt = new GradientDrawable();
        this.gRt.setShape(0);
        this.gRt.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gRt.setColors(new int[]{-10026753, -48044});
            this.gRt.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gRt;
    }

    private Drawable bWK() {
        if (this.gRu != null) {
            return this.gRu;
        }
        this.gRu = new GradientDrawable();
        this.gRu.setShape(0);
        this.gRu.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gRu.setColors(new int[]{-9549573, -831008});
            this.gRu.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gRu;
    }

    private void HI(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gRv = new AnimatorSet();
        this.gRv.setDuration(333L);
        this.gRv.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gRv.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gRw = new AnimatorSet();
        this.gRw.setDuration(666L);
        this.gRw.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gRw.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gRw.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aU(1, str);
            }
        });
        this.gRv.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gRw.start();
            }
        });
        this.gRv.start();
    }

    public void reset() {
        this.gRq = true;
        this.gRr = null;
        this.gRs = false;
        aU(0, "");
    }

    public void onDestroy() {
        this.gRq = true;
        this.gRr = null;
        this.gRs = false;
        if (this.gRv != null) {
            this.gRv.cancel();
        }
        if (this.gRw != null) {
            this.gRw.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bWJ());
                this.gRo.setImageResource(a.e.gcb_icon_enter_not_join);
                this.gRp.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aGd.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bWK());
                this.gRo.setImageResource(a.e.gcb_icon_enter_joined);
                this.gRp.setCurrentText(str);
                this.aGd.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
