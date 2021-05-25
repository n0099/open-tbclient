package com.baidu.tieba.faceshop;

import d.a.n0.l0.c.b;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class MyEmotionGroupData implements Serializable, b {
    public static final long serialVersionUID = 1;
    public String groupId;
    public int id;
    public String uid;
    public long updateTime;

    @Override // d.a.n0.l0.c.b
    public boolean IsValid() {
        return true;
    }

    @Override // d.a.n0.l0.c.b
    public String getGroupId() {
        return this.groupId;
    }

    public int getId() {
        return this.id;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
