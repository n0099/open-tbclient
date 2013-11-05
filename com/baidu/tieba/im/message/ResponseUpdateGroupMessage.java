package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.UpdateGroupInfoData;
/* loaded from: classes.dex */
public class ResponseUpdateGroupMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5970126981799423191L;
    private UpdateGroupInfoData groupInfo;

    public ResponseUpdateGroupMessage() {
    }

    public ResponseUpdateGroupMessage(int i) {
        super(i);
    }

    public UpdateGroupInfoData getUpdateGroupInfo() {
        return this.groupInfo;
    }

    public void setUpdateGroupInfo(UpdateGroupInfoData updateGroupInfoData) {
        this.groupInfo = updateGroupInfoData;
    }
}
