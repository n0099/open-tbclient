package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupActivityData;
/* loaded from: classes3.dex */
public class ResponseGetGroupActivityLocalMessage extends CustomResponsedMessage<byte[]> {
    private GroupActivityData activityData;

    public ResponseGetGroupActivityLocalMessage() {
        super(2001123);
    }

    public GroupActivityData getActivityData() {
        return this.activityData;
    }

    public void setActivityData(GroupActivityData groupActivityData) {
        this.activityData = groupActivityData;
    }
}
