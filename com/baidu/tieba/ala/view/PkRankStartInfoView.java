package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.o;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hhR;
    private PkRankStartNameView hhS;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(o oVar) {
        if (oVar != null) {
            if (this.hhR != null) {
                this.hhR.setData(oVar.baJ, oVar.fYs);
            }
            if (this.hhS != null) {
                this.hhS.setData(oVar.nickname, oVar.fYt);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hhR != null) {
            return this.hhR.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hhR != null) {
            this.hhR.release();
        }
        if (this.hhS != null) {
            this.hhS.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hhR = new PkRankStartAvatarView(getContext());
        this.hhS = new PkRankStartNameView(getContext());
        if (!z) {
            this.hhS.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hhR);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            addView(this.hhS, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        addView(this.hhS, layoutParams);
        addView(this.hhR);
    }
}
