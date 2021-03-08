package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes10.dex */
public class a {
    private AlaLiveRoomWatermarkView hUl;

    public void clV() {
        if (this.hUl != null && this.hUl.getParent() != null) {
            ((ViewGroup) this.hUl.getParent()).removeView(this.hUl);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.hUl != null) {
            this.hUl.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.hUl != null) {
            this.hUl.setVisibility(i);
        }
    }
}
