package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hPh;
    private PkRankStartNameView hPi;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.hPh != null) {
                this.hPh.setData(qVar.bgP, qVar.gAF);
            }
            if (this.hPi != null) {
                this.hPi.setData(qVar.nickname, qVar.gAG);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hPh != null) {
            return this.hPh.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hPh != null) {
            this.hPh.release();
        }
        if (this.hPi != null) {
            this.hPi.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hPh = new PkRankStartAvatarView(getContext());
        this.hPi = new PkRankStartNameView(getContext());
        if (!z) {
            this.hPi.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hPh);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.hPi, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.hPi, layoutParams);
        addView(this.hPh);
    }
}
