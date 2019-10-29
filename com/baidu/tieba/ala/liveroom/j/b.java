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
    private ImageView aiG;
    private ImageView egN;
    private TextSwitcher egO;
    private k egQ;
    private GradientDrawable egS;
    private GradientDrawable egT;
    private AnimatorSet egU;
    private AnimatorSet egV;
    private boolean isHost;
    private TbPageContext mContext;
    private View mView;
    private boolean egP = true;
    private boolean egR = false;

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        this.isHost = z;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.egN = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.egO = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aiG = (ImageView) this.mView.findViewById(a.g.iv_light);
        ab(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, k kVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (kVar != null && kVar.dOc > 0) {
                    if (this.egQ != null && TextUtils.equals(this.egQ.dOu, kVar.dOu) && TextUtils.equals(this.egQ.dOH, kVar.dOH)) {
                        if (kVar.dOc != this.egQ.dOc) {
                            this.egO.setText("Lv." + kVar.dOc + "级");
                            return;
                        }
                        return;
                    }
                    this.egQ = kVar;
                    str = "Lv." + kVar.dOc + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                ab(0, "");
                if (this.egR || z) {
                    str = null;
                } else {
                    this.egP = this.egP ? false : true;
                    return;
                }
            }
            this.egR = z;
            if (!TextUtils.isEmpty(str)) {
                tK(str);
            }
        }
    }

    private Drawable aSa() {
        if (this.egS != null) {
            return this.egS;
        }
        this.egS = new GradientDrawable();
        this.egS.setShape(0);
        this.egS.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.egS.setColors(new int[]{-10026753, -48044});
            this.egS.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.egS;
    }

    private Drawable aSb() {
        if (this.egT != null) {
            return this.egT;
        }
        this.egT = new GradientDrawable();
        this.egT.setShape(0);
        this.egT.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.egT.setColors(new int[]{-9549573, -831008});
            this.egT.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.egT;
    }

    private void tK(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.egU = new AnimatorSet();
        this.egU.setDuration(333L);
        this.egU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.egU.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.egV = new AnimatorSet();
        this.egV.setDuration(666L);
        this.egV.setInterpolator(new AccelerateDecelerateInterpolator());
        this.egV.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.egV.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.ab(1, str);
            }
        });
        this.egU.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.egV.start();
            }
        });
        this.egU.start();
    }

    public void reset() {
        this.egP = true;
        this.egQ = null;
        this.egR = false;
        ab(0, "");
    }

    public void onDestroy() {
        this.egP = true;
        this.egQ = null;
        this.egR = false;
        if (this.egU != null) {
            this.egU.cancel();
        }
        if (this.egV != null) {
            this.egV.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(aSa());
                this.egN.setImageResource(a.f.gcb_icon_enter_not_join);
                this.egO.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aiG.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(aSb());
                this.egN.setImageResource(a.f.gcb_icon_enter_joined);
                this.egO.setCurrentText(str);
                this.aiG.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
