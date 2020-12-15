package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hZH;
    private PkRankStartNameView hZI;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.hZH != null) {
                this.hZH.setData(qVar.bjs, qVar.gJl);
            }
            if (this.hZI != null) {
                this.hZI.setData(qVar.nickname, qVar.gJm);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hZH != null) {
            return this.hZH.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hZH != null) {
            this.hZH.release();
        }
        if (this.hZI != null) {
            this.hZI.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hZH = new PkRankStartAvatarView(getContext());
        this.hZI = new PkRankStartNameView(getContext());
        if (!z) {
            this.hZI.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hZH);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.hZI, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.hZI, layoutParams);
        addView(this.hZH);
    }
}
