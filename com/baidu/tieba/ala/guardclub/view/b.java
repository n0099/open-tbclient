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
/* loaded from: classes11.dex */
public class b {
    private ImageView aGu;
    private ImageView hdd;
    private TextSwitcher hde;
    private f hdg;
    private GradientDrawable hdi;
    private GradientDrawable hdj;
    private AnimatorSet hdk;
    private AnimatorSet hdl;
    private boolean isHost;
    private Context mContext;
    private View mView;
    private boolean hdf = true;
    private boolean hdh = false;

    public b(Context context, boolean z, View.OnClickListener onClickListener) {
        this.mContext = context;
        this.isHost = z;
        u(onClickListener);
    }

    private void u(View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(this.mContext).inflate(a.g.live_guard_club_widget_entry, (ViewGroup) null);
        this.mView.setId(a.f.guard_club_entry_id);
        this.hdd = (ImageView) this.mView.findViewById(a.f.iv_flag);
        this.hde = (TextSwitcher) this.mView.findViewById(a.f.ts_display);
        this.aGu = (ImageView) this.mView.findViewById(a.f.iv_light);
        aW(0, "");
        this.mView.setOnClickListener(onClickListener);
    }

    public void b(boolean z, f fVar) {
        String str;
        if (!this.isHost) {
            if (z) {
                if (fVar != null && fVar.guardLevel > 0) {
                    if (this.hdg != null && TextUtils.equals(this.hdg.aLV, fVar.aLV) && TextUtils.equals(this.hdg.bkW, fVar.bkW)) {
                        if (fVar.guardLevel != this.hdg.guardLevel) {
                            this.hde.setText("Lv." + fVar.guardLevel + "级");
                            return;
                        }
                        return;
                    }
                    this.hdg = fVar;
                    str = "Lv." + fVar.guardLevel + "级";
                } else {
                    str = "Lv.1级";
                }
            } else {
                aW(0, "");
                if (this.hdh || z) {
                    str = null;
                } else {
                    this.hdf = this.hdf ? false : true;
                    return;
                }
            }
            this.hdh = z;
            if (!TextUtils.isEmpty(str)) {
                HI(str);
            }
        }
    }

    private Drawable bZp() {
        if (this.hdi != null) {
            return this.hdi;
        }
        this.hdi = new GradientDrawable();
        this.hdi.setShape(0);
        this.hdi.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hdi.setColors(new int[]{-10026753, -48044});
            this.hdi.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hdi;
    }

    private Drawable bZq() {
        if (this.hdj != null) {
            return this.hdj;
        }
        this.hdj = new GradientDrawable();
        this.hdj.setShape(0);
        this.hdj.setCornerRadius(this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        if (Build.VERSION.SDK_INT >= 16) {
            this.hdj.setColors(new int[]{-9549573, -831008});
            this.hdj.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        }
        return this.hdj;
    }

    private void HI(final String str) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "scaleX", 1.0f, 0.7f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mView, "scaleY", 1.0f, 0.7f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.2f);
        this.hdk = new AnimatorSet();
        this.hdk.setDuration(333L);
        this.hdk.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hdk.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mView, "scaleX", 0.7f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.mView, "scaleY", 0.7f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.mView, "alpha", 0.2f, 1.0f);
        this.hdl = new AnimatorSet();
        this.hdl.setDuration(666L);
        this.hdl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hdl.play(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.hdl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.this.aW(1, str);
            }
        });
        this.hdk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.guardclub.view.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.hdl.start();
            }
        });
        this.hdk.start();
    }

    public void reset() {
        this.hdf = true;
        this.hdg = null;
        this.hdh = false;
        aW(0, "");
    }

    public void onDestroy() {
        this.hdf = true;
        this.hdg = null;
        this.hdh = false;
        if (this.hdk != null) {
            this.hdk.cancel();
        }
        if (this.hdl != null) {
            this.hdl.cancel();
        }
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, String str) {
        switch (i) {
            case 0:
                this.mView.setBackgroundDrawable(bZp());
                this.hdd.setImageResource(a.e.gcb_icon_enter_not_join);
                this.hde.setCurrentText(this.mContext.getString(a.h.guard_club));
                this.aGu.setVisibility(0);
                return;
            case 1:
                this.mView.setBackgroundDrawable(bZq());
                this.hdd.setImageResource(a.e.gcb_icon_enter_joined);
                this.hde.setCurrentText(str);
                this.aGu.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
