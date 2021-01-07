package com.baidu.tieba.faceshop;

import java.io.Serializable;
/* loaded from: classes9.dex */
public class EmotionData implements com.baidu.tieba.face.data.b, Serializable {
    private static final long serialVersionUID = 1;
    public String groupId;
    public int orderId;
    public String sharpText;

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

    @Override // com.baidu.tieba.face.data.b
    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    @Override // com.baidu.tieba.face.data.b
    public boolean IsValid() {
        return true;
    }
}
