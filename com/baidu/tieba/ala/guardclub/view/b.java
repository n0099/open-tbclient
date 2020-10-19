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
    private ImageView aEk;
    private ImageView gsI;
    private TextSwitcher gsJ;
    private f gsL;
    private GradientDrawable gsN;
    private GradientDrawable gsO;
    private AnimatorSet gsP;
    private AnimatorSet gsQ;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean gsK = true;
    private boolean gsM = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        s(onClickListener);
    }

    private void s(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.gsI = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.gsJ = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aEk = (ImageView) this.mView.findViewById(a.g.iv_light);
        aR(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.bdG > 0) {
                    if (this.gsL != null && TextUtils.equals(this.gsL.aOR, fVar.aOR) && TextUtils.equals(this.gsL.bec, fVar.bec)) {
                        if (fVar.bdG != this.gsL.bdG) {
                            this.gsJ.setText("Lv." + fVar.bdG + "级");
                            return;
                        }
                        return;
                    }
                    this.gsL = fVar;
                    str = "Lv." + fVar.bdG + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aR(0, "");
                if (this.gsM || z) {
                    str = null;
                } else {
                    this.gsK = this.gsK ? false : true;
                    return;
                }
            }
            this.gsM = z;
            if (!TextUtils.isEmpty(str)) {
                GI(str);
            }
        }
    }

    private Drawable bOC() {
        if (this.gsN != null) {
            return this.gsN;
        }
        this.gsN = new GradientDrawable();
        this.gsN.setShape(0);
        this.gsN.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gsN.setColors(new int[]{-10026753, -48044});
            this.gsN.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gsN;
    }

    private Drawable bOD() {
        if (this.gsO != null) {
            return this.gsO;
        }
        this.gsO = new GradientDrawable();
        this.gsO.setShape(0);
        this.gsO.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.gsO.setColors(new int[]{-9549573, -831008});
            this.gsO.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.gsO;
    }

    private void GI(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.gsP = new AnimatorSet();
        this.gsP.setDuration(333L);
        this.gsP.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gsP.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.gsQ = new AnimatorSet();
        this.gsQ.setDuration(666L);
        this.gsQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gsQ.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.gsQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aR(1, str);
            }
        });
        this.gsP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.gsQ.start();
            }
        });
        this.gsP.start();
    }

    public void reset() {
        this.gsK = true;
        this.gsL = null;
        this.gsM = false;
        aR(0, "");
    }

    public void onDestroy() {
        this.gsK = true;
        this.gsL = null;
        this.gsM = false;
        if (this.gsP != null) {
            this.gsP.cancel();
        }
        if (this.gsQ != null) {
            this.gsQ.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bOC());
                this.gsI.setImageResource(a.f.gcb_icon_enter_not_join);
                this.gsJ.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aEk.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bOD());
                this.gsI.setImageResource(a.f.gcb_icon_enter_joined);
                this.gsJ.setCurrentText(str);
                this.aEk.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
