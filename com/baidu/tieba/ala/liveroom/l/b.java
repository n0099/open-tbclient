package com.baidu.tieba.ala.liveroom.l;

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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.guardclub.model.k;
/* loaded from: classes2.dex */
public class b {
    private ImageView aqY;
    private ImageView eYq;
    private TextSwitcher eYr;
    private k eYt;
    private GradientDrawable eYv;
    private GradientDrawable eYw;
    private AnimatorSet eYx;
    private AnimatorSet eYy;
    private boolean isHost;
    private TbPageContext mContext;
    private View mView;
    private boolean eYs = true;
    private boolean eYu = false;

    public b(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        this.mContext = tbPageContext;
        this.isHost = z;
        a(this.mContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(a.h.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.g.guard_club_entry_id);
        this.eYq = (ImageView) this.mView.findViewById(a.g.iv_flag);
        this.eYr = (TextSwitcher) this.mView.findViewById(a.g.ts_display);
        this.aqY = (ImageView) this.mView.findViewById(a.g.iv_light);
        au(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, k kVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (kVar != null && kVar.eCE > 0) {
                    if (this.eYt != null && TextUtils.equals(this.eYt.abx, kVar.abx) && TextUtils.equals(this.eYt.eDi, kVar.eDi)) {
                        if (kVar.eCE != this.eYt.eCE) {
                            this.eYr.setText("Lv." + kVar.eCE + "级");
                            return;
                        }
                        return;
                    }
                    this.eYt = kVar;
                    str = "Lv." + kVar.eCE + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                au(0, "");
                if (this.eYu || z) {
                    str = null;
                } else {
                    this.eYs = this.eYs ? false : true;
                    return;
                }
            }
            this.eYu = z;
            if (!TextUtils.isEmpty(str)) {
                yI(str);
            }
        }
    }

    private Drawable bkt() {
        if (this.eYv != null) {
            return this.eYv;
        }
        this.eYv = new GradientDrawable();
        this.eYv.setShape(0);
        this.eYv.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eYv.setColors(new int[]{-10026753, -48044});
            this.eYv.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eYv;
    }

    private Drawable bku() {
        if (this.eYw != null) {
            return this.eYw;
        }
        this.eYw = new GradientDrawable();
        this.eYw.setShape(0);
        this.eYw.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.eYw.setColors(new int[]{-9549573, -831008});
            this.eYw.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.eYw;
    }

    private void yI(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.eYx = new AnimatorSet();
        this.eYx.setDuration(333L);
        this.eYx.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eYx.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.eYy = new AnimatorSet();
        this.eYy.setDuration(666L);
        this.eYy.setInterpolator(new AccelerateDecelerateInterpolator());
        this.eYy.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.eYy.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.l.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.au(1, str);
            }
        });
        this.eYx.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.l.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.eYy.start();
            }
        });
        this.eYx.start();
    }

    public void reset() {
        this.eYs = true;
        this.eYt = null;
        this.eYu = false;
        au(0, "");
    }

    public void onDestroy() {
        this.eYs = true;
        this.eYt = null;
        this.eYu = false;
        if (this.eYx != null) {
            this.eYx.cancel();
        }
        if (this.eYy != null) {
            this.eYy.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bkt());
                this.eYq.setImageResource(a.f.gcb_icon_enter_not_join);
                this.eYr.setCurrentText(this.mContext.getString(a.i.guard_club));
                this.aqY.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bku());
                this.eYq.setImageResource(a.f.gcb_icon_enter_joined);
                this.eYr.setCurrentText(str);
                this.aqY.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
