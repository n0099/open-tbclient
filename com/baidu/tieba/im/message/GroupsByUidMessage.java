package com.baidu.tieba.im.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupsByUid.DataReq;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReqIdl;
/* loaded from: classes10.dex */
public class GroupsByUidMessage extends TbSocketMessage {
    private long friendUid;
    private int height;
    private int isFriend;
    private int width;

    public GroupsByUidMessage(int i, int i2) {
        super(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID);
        this.width = i;
        this.height = i2;
        this.friendUid = 0L;
        this.isFriend = 0;
    }

    public GroupsByUidMessage(long j, int i, int i2) {
        super(CmdConfigSocket.CMD_QUERY_GROUP_BY_UID);
        this.width = i;
        this.height = i2;
        this.friendUid = j;
        this.isFriend = 1;
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

    public long getFriendUid() {
        return this.friendUid;
    }

    public void setFriendUid(long j) {
        this.friendUid = j;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsGuest(int i) {
        this.isFriend = i;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.width = Integer.valueOf(getWidth());
        builder.height = Integer.valueOf(getHeight());
        if (this.isFriend == 1) {
            builder.friendId = Long.valueOf(getFriendUid());
            builder.isGuest = Integer.valueOf(getIsFriend());
        }
        QueryGroupsByUidReqIdl.Builder builder2 = new QueryGroupsByUidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
