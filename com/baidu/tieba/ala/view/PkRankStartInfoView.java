package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes11.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView imZ;
    private PkRankStartNameView ina;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.imZ != null) {
                this.imZ.setData(qVar.aVj, qVar.gTc);
            }
            if (this.ina != null) {
                this.ina.setData(qVar.nickname, qVar.gTd);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.imZ != null) {
            return this.imZ.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.imZ != null) {
            this.imZ.release();
        }
        if (this.ina != null) {
            this.ina.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.imZ = new PkRankStartAvatarView(getContext());
        this.ina = new PkRankStartNameView(getContext());
        if (!z) {
            this.ina.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.imZ);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.ina, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.ina, layoutParams);
        addView(this.imZ);
    }
}
