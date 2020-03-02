package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView foa;
    private TbPageContext mTbPageContext;

    public void brt() {
        if (this.foa != null && this.foa.getParent() != null) {
            ((ViewGroup) this.foa.getParent()).removeView(this.foa);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.foa != null) {
            this.foa.setTimeTextMode(z);
        }
    }

    public int bru() {
        int i = 0;
        if (this.foa == null || this.foa.getLayoutParams() == null) {
            return 0;
        }
        if (this.foa.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.foa.getLayoutParams()).topMargin;
        } else if (this.foa.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.foa.getLayoutParams()).topMargin;
        } else if (this.foa.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.foa.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.foa != null) {
            this.foa.setVisibility(i);
        }
    }
}
