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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.guardclub.model.k;
/* loaded from: classes2.dex */
public class b {
    private ImageView aqm;
    private ImageView eVQ;
    private TextSwitcher eVR;
    private k eVT;
    private GradientDrawable eVV;
    private GradientDrawable eVW;
    private AnimatorSet eVX;
    private AnimatorSet eVY;
    private boolean isHost;
    private TbPageContext mContext;
    private View mView;
    private boolean eVS = true;
    private boolean eVU = false;

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        this.isHost = z;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.eVQ = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.eVR = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aqm = (ImageView) this.mView.findViewById(a.g.iv_light);
        ap(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, k kVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (kVar != null && kVar.eBt > 0) {
                    if (this.eVT != null && TextUtils.equals(this.eVT.abl, kVar.abl) && TextUtils.equals(this.eVT.eBX, kVar.eBX)) {
                        if (kVar.eBt != this.eVT.eBt) {
                            this.eVR.setText("Lv." + kVar.eBt + "级");
                            return;
                        }
                        return;
                    }
                    this.eVT = kVar;
                    str = "Lv." + kVar.eBt + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                ap(0, "");
                if (this.eVU || z) {
                    str = null;
                } else {
                    this.eVS = this.eVS ? false : true;
                    return;
                }
            }
            this.eVU = z;
            if (!TextUtils.isEmpty(str)) {
                yz(str);
            }
        }
    }

    private Drawable bjx() {
        if (this.eVV != null) {
            return this.eVV;
        }
        this.eVV = new GradientDrawable();
        this.eVV.setShape(0);
        this.eVV.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eVV.setColors(new int[]{-10026753, -48044});
            this.eVV.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eVV;
    }

    private Drawable bjy() {
        if (this.eVW != null) {
            return this.eVW;
        }
        this.eVW = new GradientDrawable();
        this.eVW.setShape(0);
        this.eVW.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eVW.setColors(new int[]{-9549573, -831008});
            this.eVW.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eVW;
    }

    private void yz(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.eVX = new AnimatorSet();
        this.eVX.setDuration(333L);
        this.eVX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eVX.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.eVY = new AnimatorSet();
        this.eVY.setDuration(666L);
        this.eVY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eVY.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eVY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.j.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.ap(1, str);
            }
        });
        this.eVX.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.j.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.eVY.start();
            }
        });
        this.eVX.start();
    }

    public void reset() {
        this.eVS = true;
        this.eVT = null;
        this.eVU = false;
        ap(0, "");
    }

    public void onDestroy() {
        this.eVS = true;
        this.eVT = null;
        this.eVU = false;
        if (this.eVX != null) {
            this.eVX.cancel();
        }
        if (this.eVY != null) {
            this.eVY.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bjx());
                this.eVQ.setImageResource(a.f.gcb_icon_enter_not_join);
                this.eVR.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aqm.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bjy());
                this.eVQ.setImageResource(a.f.gcb_icon_enter_joined);
                this.eVR.setCurrentText(str);
                this.aqm.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
