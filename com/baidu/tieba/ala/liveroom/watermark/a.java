package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class a {
    private AlaLiveRoomWatermarkView flf;
    private TbPageContext mTbPageContext;

    public void bpK() {
        if (this.flf != null && this.flf.getParent() != null) {
            ((ViewGroup) this.flf.getParent()).removeView(this.flf);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.flf != null) {
            this.flf.setTimeTextMode(z);
        }
    }

    public int bpL() {
        int i = 0;
        if (this.flf == null || this.flf.getLayoutParams() == null) {
            return 0;
        }
        if (this.flf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.flf.getLayoutParams()).topMargin;
        } else if (this.flf.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.flf.getLayoutParams()).topMargin;
        } else if (this.flf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.flf.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.flf != null) {
            this.flf.setVisibility(i);
        }
    }
}
