package com.baidu.tbadk.mutiprocess.event;

import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes2.dex */
public class GoodsEvent extends SerializableEvent {
    private boolean dispose;
    private String goodsList;

    public GoodsEvent(String str) {
        this.goodsList = str;
    }

    public String getGoodsList() {
        return this.goodsList;
    }

    public boolean getDispose() {
        return this.dispose;
    }

    public void setDispost(boolean z) {
        this.dispose = z;
    }
}
