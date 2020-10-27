package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hJk;
    private PkRankStartNameView hJl;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.hJk != null) {
                this.hJk.setData(qVar.bfv, qVar.guR);
            }
            if (this.hJl != null) {
                this.hJl.setData(qVar.nickname, qVar.guS);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hJk != null) {
            return this.hJk.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hJk != null) {
            this.hJk.release();
        }
        if (this.hJl != null) {
            this.hJl.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hJk = new PkRankStartAvatarView(getContext());
        this.hJl = new PkRankStartNameView(getContext());
        if (!z) {
            this.hJl.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hJk);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            addView(this.hJl, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        addView(this.hJl, layoutParams);
        addView(this.hJk);
    }
}
