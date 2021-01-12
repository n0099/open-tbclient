package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes10.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartNameView ihA;
    private PkRankStartAvatarView ihz;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.ihz != null) {
                this.ihz.setData(qVar.aSf, qVar.gQs);
            }
            if (this.ihA != null) {
                this.ihA.setData(qVar.nickname, qVar.gQt);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.ihz != null) {
            return this.ihz.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.ihz != null) {
            this.ihz.release();
        }
        if (this.ihA != null) {
            this.ihA.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.ihz = new PkRankStartAvatarView(getContext());
        this.ihA = new PkRankStartNameView(getContext());
        if (!z) {
            this.ihA.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.ihz);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.ihA, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.ihA, layoutParams);
        addView(this.ihz);
    }
}
