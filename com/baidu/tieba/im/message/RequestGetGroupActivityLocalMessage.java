package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class RequestGetGroupActivityLocalMessage extends CustomMessage<Integer> {
    private int activityId;
    private int from;

    public RequestGetGroupActivityLocalMessage() {
        super(2001127);
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
