package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes11.dex */
public class a {
    private AlaLiveRoomWatermarkView hSy;

    public void coC() {
        if (this.hSy != null && this.hSy.getParent() != null) {
            ((ViewGroup) this.hSy.getParent()).removeView(this.hSy);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hSy != null) {
            this.hSy.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hSy != null) {
            this.hSy.setVisibility(i);
        }
    }
}
