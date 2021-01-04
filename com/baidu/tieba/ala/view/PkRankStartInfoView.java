package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes11.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView imh;
    private PkRankStartNameView imi;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.imh != null) {
                this.imh.setData(qVar.aWS, qVar.gUY);
            }
            if (this.imi != null) {
                this.imi.setData(qVar.nickname, qVar.gUZ);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.imh != null) {
            return this.imh.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.imh != null) {
            this.imh.release();
        }
        if (this.imi != null) {
            this.imi.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.imh = new PkRankStartAvatarView(getContext());
        this.imi = new PkRankStartNameView(getContext());
        if (!z) {
            this.imi.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.imh);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.imi, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.imi, layoutParams);
        addView(this.imh);
    }
}
