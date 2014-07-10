package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QuitChatroom.DataReq;
import protobuf.QuitChatroom.QuitChatroomReqIdl;
/* loaded from: classes.dex */
public class RequestQuitChatRoomMessage extends TbSocketMessage {
    public static final int TAG_CHAT = 1;
    public static final int TAG_WAIT = 0;
    private int mGroupId;
    private int mNeedFreeze;
    private int mTag;

    public RequestQuitChatRoomMessage(int i, int i2, int i3) {
        super(106102);
        this.mGroupId = i;
        this.mNeedFreeze = i2;
        this.mTag = i3;
    }

    public int getChatTag() {
        return this.mTag;
    }

    public void setChatTag(int i) {
        this.mTag = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Integer.valueOf(this.mGroupId);
            builder.needFreeze = Integer.valueOf(this.mNeedFreeze);
            QuitChatroomReqIdl.Builder builder2 = new QuitChatroomReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
