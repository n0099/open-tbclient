package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView fTn;
    private TbPageContext mTbPageContext;

    public void bBa() {
        if (this.fTn != null && this.fTn.getParent() != null) {
            ((ViewGroup) this.fTn.getParent()).removeView(this.fTn);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.fTn != null) {
            this.fTn.setTimeTextMode(z);
        }
    }

    public int bBb() {
        int i = 0;
        if (this.fTn == null || this.fTn.getLayoutParams() == null) {
            return 0;
        }
        if (this.fTn.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.fTn.getLayoutParams()).topMargin;
        } else if (this.fTn.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.fTn.getLayoutParams()).topMargin;
        } else if (this.fTn.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.fTn.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.fTn != null) {
            this.fTn.setVisibility(i);
        }
    }
}
