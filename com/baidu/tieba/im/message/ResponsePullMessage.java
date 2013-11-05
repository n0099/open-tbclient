package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.GroupMsgData;
import java.util.List;
/* loaded from: classes.dex */
public class ResponsePullMessage extends ResponsedMessage {
    private static final long serialVersionUID = 528925898590517124L;
    private List<GroupMsgData> groupMsg;

    public ResponsePullMessage() {
        super(202003);
    }

    public List<GroupMsgData> getGroupMsg() {
        return this.groupMsg;
    }

    public void setGroupMsg(List<GroupMsgData> list) {
        this.groupMsg = list;
    }
}
