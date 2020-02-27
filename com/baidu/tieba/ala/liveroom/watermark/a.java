package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView fnZ;
    private TbPageContext mTbPageContext;

    public void brr() {
        if (this.fnZ != null && this.fnZ.getParent() != null) {
            ((ViewGroup) this.fnZ.getParent()).removeView(this.fnZ);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.fnZ != null) {
            this.fnZ.setTimeTextMode(z);
        }
    }

    public int brs() {
        int i = 0;
        if (this.fnZ == null || this.fnZ.getLayoutParams() == null) {
            return 0;
        }
        if (this.fnZ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.fnZ.getLayoutParams()).topMargin;
        } else if (this.fnZ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.fnZ.getLayoutParams()).topMargin;
        } else if (this.fnZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.fnZ.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.fnZ != null) {
            this.fnZ.setVisibility(i);
        }
    }
}
