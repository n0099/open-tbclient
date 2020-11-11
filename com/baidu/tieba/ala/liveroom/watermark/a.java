package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class a {
    private AlaLiveRoomWatermarkView hxk;

    public void civ() {
        if (this.hxk != null && this.hxk.getParent() != null) {
            ((ViewGroup) this.hxk.getParent()).removeView(this.hxk);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hxk != null) {
            this.hxk.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hxk != null) {
            this.hxk.setVisibility(i);
        }
    }
}
