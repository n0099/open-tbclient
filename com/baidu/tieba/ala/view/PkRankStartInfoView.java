package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hOO;
    private PkRankStartNameView hOP;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.hOO != null) {
                this.hOO.setData(qVar.bfc, qVar.gAm);
            }
            if (this.hOP != null) {
                this.hOP.setData(qVar.nickname, qVar.gAn);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hOO != null) {
            return this.hOO.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hOO != null) {
            this.hOO.release();
        }
        if (this.hOP != null) {
            this.hOP.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hOO = new PkRankStartAvatarView(getContext());
        this.hOP = new PkRankStartNameView(getContext());
        if (!z) {
            this.hOP.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hOO);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.hOP, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.hOP, layoutParams);
        addView(this.hOO);
    }
}
