package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView gir;
    private TbPageContext mTbPageContext;

    public void bHw() {
        if (this.gir != null && this.gir.getParent() != null) {
            ((ViewGroup) this.gir.getParent()).removeView(this.gir);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.gir != null) {
            this.gir.setTimeTextMode(z);
        }
    }

    public int bHx() {
        int i = 0;
        if (this.gir == null || this.gir.getLayoutParams() == null) {
            return 0;
        }
        if (this.gir.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.gir.getLayoutParams()).topMargin;
        } else if (this.gir.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.gir.getLayoutParams()).topMargin;
        } else if (this.gir.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.gir.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.gir != null) {
            this.gir.setVisibility(i);
        }
    }
}
