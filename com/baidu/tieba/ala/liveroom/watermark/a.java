package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView gvd;
    private TbPageContext mTbPageContext;

    public void bKB() {
        if (this.gvd != null && this.gvd.getParent() != null) {
            ((ViewGroup) this.gvd.getParent()).removeView(this.gvd);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gvd != null) {
            this.gvd.setTimeTextMode(z);
        }
    }

    public int bKC() {
        int i = 0;
        if (this.gvd == null || this.gvd.getLayoutParams() == null) {
            return 0;
        }
        if (this.gvd.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.gvd.getLayoutParams()).topMargin;
        } else if (this.gvd.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.gvd.getLayoutParams()).topMargin;
        } else if (this.gvd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.gvd.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.gvd != null) {
            this.gvd.setVisibility(i);
        }
    }
}
