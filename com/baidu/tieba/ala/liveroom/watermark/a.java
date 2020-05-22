package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView gig;
    private TbPageContext mTbPageContext;

    public void bHu() {
        if (this.gig != null && this.gig.getParent() != null) {
            ((ViewGroup) this.gig.getParent()).removeView(this.gig);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gig != null) {
            this.gig.setTimeTextMode(z);
        }
    }

    public int bHv() {
        int i = 0;
        if (this.gig == null || this.gig.getLayoutParams() == null) {
            return 0;
        }
        if (this.gig.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.gig.getLayoutParams()).topMargin;
        } else if (this.gig.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.gig.getLayoutParams()).topMargin;
        } else if (this.gig.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.gig.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.gig != null) {
            this.gig.setVisibility(i);
        }
    }
}
