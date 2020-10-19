package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.content.Context;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.data.o;
/* loaded from: classes4.dex */
public class PkRankStartInfoView extends LinearLayout {
    private PkRankStartAvatarView hwN;
    private PkRankStartNameView hwO;

    public PkRankStartInfoView(Context context, boolean z) {
        super(context);
        init(z);
    }

    public void setData(o oVar) {
        if (oVar != null) {
            if (this.hwN != null) {
                this.hwN.setData(oVar.bed, oVar.gkK);
            }
            if (this.hwO != null) {
                this.hwO.setData(oVar.nickname, oVar.gkL);
            }
        }
    }

    public Animator getStreakAnim() {
        if (this.hwN != null) {
            return this.hwN.getStreakAnim();
        }
        return null;
    }

    public void release() {
        if (this.hwN != null) {
            this.hwN.release();
        }
        if (this.hwO != null) {
            this.hwO.release();
        }
    }

    private void init(boolean z) {
        setBackgroundColor(0);
        setOrientation(0);
        this.hwN = new PkRankStartAvatarView(getContext());
        this.hwO = new PkRankStartNameView(getContext());
        if (!z) {
            this.hwO.setGravity(5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        if (z) {
            addView(this.hwN);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            addView(this.hwO, layoutParams);
            return;
        }
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        addView(this.hwO, layoutParams);
        addView(this.hwN);
    }
}
