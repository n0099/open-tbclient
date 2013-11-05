package com.baidu.tieba.im.message;

import com.baidu.tieba.im.data.MembersData;
/* loaded from: classes.dex */
public class ResponseMembersMessage extends ResponsedMessage {
    private static final long serialVersionUID = 1311430402761584874L;
    private MembersData membersData;

    public ResponseMembersMessage() {
    }

    public ResponseMembersMessage(int i) {
        super(i);
    }

    public MembersData getMembersData() {
        return this.membersData;
    }

    public void setMembersData(MembersData membersData) {
        this.membersData = membersData;
    }
}
