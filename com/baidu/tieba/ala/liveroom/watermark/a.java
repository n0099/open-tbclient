package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView fTi;
    private TbPageContext mTbPageContext;

    public void bBc() {
        if (this.fTi != null && this.fTi.getParent() != null) {
            ((ViewGroup) this.fTi.getParent()).removeView(this.fTi);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.fTi != null) {
            this.fTi.setTimeTextMode(z);
        }
    }

    public int bBd() {
        int i = 0;
        if (this.fTi == null || this.fTi.getLayoutParams() == null) {
            return 0;
        }
        if (this.fTi.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.fTi.getLayoutParams()).topMargin;
        } else if (this.fTi.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.fTi.getLayoutParams()).topMargin;
        } else if (this.fTi.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.fTi.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.fTi != null) {
            this.fTi.setVisibility(i);
        }
    }
}
