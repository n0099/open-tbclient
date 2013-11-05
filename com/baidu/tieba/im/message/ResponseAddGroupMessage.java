package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.AddGroupInfoData;
/* loaded from: classes.dex */
public class ResponseAddGroupMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5970126981799423191L;
    private AddGroupInfoData groupInfo;

    public ResponseAddGroupMessage() {
    }

    public ResponseAddGroupMessage(int i) {
        super(i);
    }

    public AddGroupInfoData getAddGroupInfo() {
        return this.groupInfo;
    }

    public void setAddGroupInfo(AddGroupInfoData addGroupInfoData) {
        this.groupInfo = addGroupInfoData;
    }
}
