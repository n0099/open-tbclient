package com.baidu.tbadk.editortool;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EmotionData implements x, Serializable {
    private static final long serialVersionUID = 1;
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

    @Override // com.baidu.tbadk.editortool.x
    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    @Override // com.baidu.tbadk.editortool.x
    public boolean IsValid() {
        return true;
    }
}
