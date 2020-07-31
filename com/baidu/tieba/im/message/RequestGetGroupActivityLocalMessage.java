package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes17.dex */
public class RequestGetGroupActivityLocalMessage extends CustomMessage<Integer> {
    private int activityId;
    private int from;

    public RequestGetGroupActivityLocalMessage() {
        super(CmdConfigCustom.CMD_REQUEST_GROUP_ACTIVITY_BY_ID_LOCAL);
    }

    public int getFrom() {
        return this.from;
    }

    public void setFrom(int i) {
        this.from = i;
    }

    public int getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int i) {
        this.activityId = i;
    }
}
