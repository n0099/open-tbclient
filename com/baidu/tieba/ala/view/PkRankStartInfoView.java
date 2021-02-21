package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.q;
/* loaded from: classes11.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView inn;
    private PkRankStartNameView ino;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(q qVar) {
        if (qVar != null) {
            if (this.inn != null) {
                this.inn.setData(qVar.aVj, qVar.gTq);
            }
            if (this.ino != null) {
                this.ino.setData(qVar.nickname, qVar.gTr);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.inn != null) {
            return this.inn.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.inn != null) {
            this.inn.release();
        }
        if (this.ino != null) {
            this.ino.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.inn = new PkRankStartAvatarView(getContext());
        this.ino = new PkRankStartNameView(getContext());
        if (!z) {
            this.ino.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.inn);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            addView(this.ino, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds16);
        addView(this.ino, layoutParams);
        addView(this.inn);
    }
}
