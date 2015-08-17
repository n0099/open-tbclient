package com.baidu.tbadk.editortools.emotiontool;

import java.io.Serializable;
/* loaded from: classes.dex */
public class EmotionData implements p, Serializable {
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

    @Override // com.baidu.tbadk.editortools.emotiontool.p
    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.p
    public boolean IsValid() {
        return true;
    }
}
