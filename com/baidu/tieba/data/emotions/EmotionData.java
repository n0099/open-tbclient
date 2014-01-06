package com.baidu.tieba.data.emotions;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EmotionData implements Serializable {
    protected String groupId;
    protected int orderId;
    protected String sharpText;

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    public String getSharpText() {
        return this.sharpText;
    }

    public void setSharpText(String str) {
        this.sharpText = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
