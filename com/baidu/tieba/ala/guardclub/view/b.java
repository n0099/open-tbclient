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
    private ImageView gRq;
    private TextSwitcher gRr;
    private f gRt;
    private GradientDrawable gRv;
    private GradientDrawable gRw;
    private AnimatorSet gRx;
    private AnimatorSet gRy;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gRs = true;
    private boolean gRu = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        t(onClickListener);
    }

    private void t(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.gRq = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.gRr = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aGd = (ImageView) this.mView.findViewById(a.f.iv_light);
        aU(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.guardLevel > 0) {
                    if (this.gRt != null && TextUtils.equals(this.gRt.aRO, fVar.aRO) && TextUtils.equals(this.gRt.bjr, fVar.bjr)) {
                        if (fVar.guardLevel != this.gRt.guardLevel) {
                            this.gRr.setText("Lv." + fVar.guardLevel + "级");
                            return;
                        }
                        return;
                    }
                    this.gRt = fVar;
                    str = "Lv." + fVar.guardLevel + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aU(0, "");
                if (this.gRu || z) {
                    str = null;
                } else {
                    this.gRs = this.gRs ? false : true;
                    return;
                }
            }
            this.gRu = z;
            if (!TextUtils.isEmpty(str)) {
                HI(str);
            }
        }
    }

    private Drawable bWK() {
        if (this.gRv != null) {
            return this.gRv;
        }
        this.gRv = new GradientDrawable();
        this.gRv.setShape(0);
        this.gRv.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gRv.setColors(new int[]{-10026753, -48044});
            this.gRv.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gRv;
    }

    private Drawable bWL() {
        if (this.gRw != null) {
            return this.gRw;
        }
        this.gRw = new GradientDrawable();
        this.gRw.setShape(0);
        this.gRw.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gRw.setColors(new int[]{-9549573, -831008});
            this.gRw.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gRw;
    }

    private void HI(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gRx = new AnimatorSet();
        this.gRx.setDuration(333L);
        this.gRx.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gRx.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gRy = new AnimatorSet();
        this.gRy.setDuration(666L);
        this.gRy.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gRy.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gRy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aU(1, str);
            }
        });
        this.gRx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gRy.start();
            }
        });
        this.gRx.start();
    }

    public void reset() {
        this.gRs = true;
        this.gRt = null;
        this.gRu = false;
        aU(0, "");
    }

    public void onDestroy() {
        this.gRs = true;
        this.gRt = null;
        this.gRu = false;
        if (this.gRx != null) {
            this.gRx.cancel();
        }
        if (this.gRy != null) {
            this.gRy.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bWK());
                this.gRq.setImageResource(a.e.gcb_icon_enter_not_join);
                this.gRr.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aGd.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bWL());
                this.gRq.setImageResource(a.e.gcb_icon_enter_joined);
                this.gRr.setCurrentText(str);
                this.aGd.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
