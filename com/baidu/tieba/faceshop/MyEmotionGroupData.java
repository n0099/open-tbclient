package com.baidu.tieba.faceshop;

import java.io.Serializable;
/* loaded from: classes8.dex */
public class MyEmotionGroupData implements com.baidu.tieba.face.data.b, Serializable {
    private static final long serialVersionUID = 1;
    protected String groupId;
    protected int id;
    protected String uid;
    protected long updateTime;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @Override // com.baidu.tieba.face.data.b
    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    @Override // com.baidu.tieba.face.data.b
    public boolean IsValid() {
        return true;
    }
}
