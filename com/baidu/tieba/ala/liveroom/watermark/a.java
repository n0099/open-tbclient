package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView fon;
    private TbPageContext mTbPageContext;

    public void bru() {
        if (this.fon != null && this.fon.getParent() != null) {
            ((ViewGroup) this.fon.getParent()).removeView(this.fon);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.fon != null) {
            this.fon.setTimeTextMode(z);
        }
    }

    public int brv() {
        int i = 0;
        if (this.fon == null || this.fon.getLayoutParams() == null) {
            return 0;
        }
        if (this.fon.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.fon.getLayoutParams()).topMargin;
        } else if (this.fon.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.fon.getLayoutParams()).topMargin;
        } else if (this.fon.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.fon.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.fon != null) {
            this.fon.setVisibility(i);
        }
    }
}
