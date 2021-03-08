package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes10.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView ioX;
    private PkRankStartNameView ioY;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.ioX != null) {
                this.ioX.setData(qVar.aWJ, qVar.gUZ);
            }
            if (this.ioY != null) {
                this.ioY.setData(qVar.nickname, qVar.gVa);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.ioX != null) {
            return this.ioX.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.ioX != null) {
            this.ioX.release();
        }
        if (this.ioY != null) {
            this.ioY.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.ioX = new PkRankStartAvatarView(getContext());
        this.ioY = new PkRankStartNameView(getContext());
        if (!z) {
            this.ioY.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.ioX);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.ioY, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.ioY, layoutParams);
        addView(this.ioX);
    }
}
