package com.baidu.tieba.faceshop;

import d.b.j0.k0.c.b;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class EmotionData implements Serializable, b {
    public static final long serialVersionUID = 1;
    public String groupId;
    public int orderId;
    public String sharpText;

    @Override // d.b.j0.k0.c.b
    public boolean IsValid() {
        return true;
    }

    @Override // d.b.j0.k0.c.b
    public String getGroupId() {
        return this.groupId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getSharpText() {
        return this.sharpText;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setOrderId(int i) {
        this.orderId = i;
    }

    public void setSharpText(String str) {
        this.sharpText = str;
    }
}
