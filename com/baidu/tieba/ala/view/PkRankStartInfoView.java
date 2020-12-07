package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hZF;
    private PkRankStartNameView hZG;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.hZF != null) {
                this.hZF.setData(qVar.bjs, qVar.gJj);
            }
            if (this.hZG != null) {
                this.hZG.setData(qVar.nickname, qVar.gJk);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hZF != null) {
            return this.hZF.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hZF != null) {
            this.hZF.release();
        }
        if (this.hZG != null) {
            this.hZG.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hZF = new PkRankStartAvatarView(getContext());
        this.hZG = new PkRankStartNameView(getContext());
        if (!z) {
            this.hZG.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hZF);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.hZG, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.hZG, layoutParams);
        addView(this.hZF);
    }
}
