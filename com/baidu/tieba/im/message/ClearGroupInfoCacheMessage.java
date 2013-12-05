package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ClearGroupInfoCacheMessage extends Message {
    private static final long serialVersionUID = -8241350660108126818L;
    private String groupId;

    public ClearGroupInfoCacheMessage() {
        super.setCmd(-117);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
