package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.data.GroupActivityData;
/* loaded from: classes17.dex */
public class ResponseGetGroupActivityLocalMessage extends CustomResponsedMessage<byte[]> {
    private GroupActivityData activityData;

    public ResponseGetGroupActivityLocalMessage() {
        super(CmdConfigCustom.CMD_REQUEST_GROUP_ACTIVITY_BY_ID_LOCAL);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    public void setActivityData(GroupActivityData groupActivityData) {
        this.activityData = groupActivityData;
    }
}
