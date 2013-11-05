package com.baidu.tieba.im.message;

import java.util.List;
/* loaded from: classes.dex */
public class ResponseOnlineMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5970126981799423191L;
    private List<GroupUpdateMessage> groupInfos;

    public ResponseOnlineMessage() {
        super(1001);
    }

    public List<GroupUpdateMessage> getGroupInfos() {
        return this.groupInfos;
    }

    public void setGroupInfos(List<GroupUpdateMessage> list) {
        this.groupInfos = list;
    }
}
