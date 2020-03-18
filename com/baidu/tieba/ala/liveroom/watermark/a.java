package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private AlaLiveRoomWatermarkView foM;
    private TbPageContext mTbPageContext;

    public void brz() {
        if (this.foM != null && this.foM.getParent() != null) {
            ((ViewGroup) this.foM.getParent()).removeView(this.foM);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.foM != null) {
            this.foM.setTimeTextMode(z);
        }
    }

    public int brA() {
        int i = 0;
        if (this.foM == null || this.foM.getLayoutParams() == null) {
            return 0;
        }
        if (this.foM.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            i = ((FrameLayout.LayoutParams) this.foM.getLayoutParams()).topMargin;
        } else if (this.foM.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            i = ((RelativeLayout.LayoutParams) this.foM.getLayoutParams()).topMargin;
        } else if (this.foM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            i = ((LinearLayout.LayoutParams) this.foM.getLayoutParams()).topMargin;
        }
        return i + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds30);
    }

    public void setVisibility(int i) {
        if (this.foM != null) {
            this.foM.setVisibility(i);
        }
    }
}
