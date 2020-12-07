package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView hGw;

    public void clJ() {
        if (this.hGw != null && this.hGw.getParent() != null) {
            ((ViewGroup) this.hGw.getParent()).removeView(this.hGw);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hGw != null) {
            this.hGw.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hGw != null) {
            this.hGw.setVisibility(i);
        }
    }
}
