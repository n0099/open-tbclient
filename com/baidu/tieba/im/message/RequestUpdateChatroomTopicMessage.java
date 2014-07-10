package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.UpdateChatroomTopic.DataReq;
import protobuf.UpdateChatroomTopic.UpdateChatroomTopicReqIdl;
/* loaded from: classes.dex */
public class RequestUpdateChatroomTopicMessage extends TbSocketMessage {
    private String mContent;
    private int mGroupId;
    private String mTitle;

    public RequestUpdateChatroomTopicMessage() {
        super(106103);
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getContent() {
        return this.mContent;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.groupId = Integer.valueOf(getGroupId());
            builder.title = getTitle();
            builder.content = getContent();
            UpdateChatroomTopicReqIdl.Builder builder2 = new UpdateChatroomTopicReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }
}
