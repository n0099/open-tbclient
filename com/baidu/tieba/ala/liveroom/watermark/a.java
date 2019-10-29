package com.baidu.tieba.ala.liveroom.watermark;

import android.view.ViewGroup;
/* loaded from: classes6.dex */
public class a {
    private AlaLiveRoomWatermarkView esq;

    public void aWY() {
        if (this.esq != null && this.esq.getParent() != null) {
            ((ViewGroup) this.esq.getParent()).removeView(this.esq);
        }
    }

    public void setTimeTextMode(boolean z) {
        if (this.esq != null) {
            this.esq.setTimeTextMode(z);
        }
    }

    public void setVisibility(int i) {
        if (this.esq != null) {
            this.esq.setVisibility(i);
        }
    }
}
