package com.baidu.tieba.im.message;

import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupsByUid.DataReq;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReqIdl;
/* loaded from: classes.dex */
public class GroupsByUidMessage extends TbSocketMessage {
    private int height;
    private int width;

    public GroupsByUidMessage(int i, int i2) {
        super(MessageTypes.CMD_QUERY_GROUP_BY_UID);
        this.width = i;
        this.height = i2;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.width = Integer.valueOf(getWidth());
        builder.height = Integer.valueOf(getHeight());
        QueryGroupsByUidReqIdl.Builder builder2 = new QueryGroupsByUidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
