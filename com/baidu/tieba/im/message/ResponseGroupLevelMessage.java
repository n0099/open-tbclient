package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupLevelInfo;
/* loaded from: classes.dex */
public class ResponseGroupLevelMessage extends ResponsedMessage {
    private static final long serialVersionUID = -4932698903767164290L;
    private GroupLevelInfo groupLevelInfo;

    public ResponseGroupLevelMessage() {
    }

    public ResponseGroupLevelMessage(int i) {
        super(i);
    }

    public GroupLevelInfo getGroupLevelInfo() {
        return this.groupLevelInfo;
    }

    public void setGroupLevelInfo(GroupLevelInfo groupLevelInfo) {
        this.groupLevelInfo = groupLevelInfo;
    }
}
